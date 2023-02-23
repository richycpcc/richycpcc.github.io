package io.catalyte.springboot.services;

import io.catalyte.springboot.entities.Products;
import io.catalyte.springboot.exceptions.*;
import io.catalyte.springboot.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

import static io.catalyte.springboot.constants.StringConstants.EMAIL_CONFLICT;
import static io.catalyte.springboot.constants.StringConstants.SKU_CONFLICT;


@Service
public class ProductsServicesImpl implements ProductsService
{
    private ProductsRepository productsRepository;

    private Products products;
    Boolean skuAlreadyExists;


    @Autowired
    public ProductsServicesImpl(ProductsRepository productsRepository){
        this.productsRepository = productsRepository;
    }

    /**
     * Reads all Products from the database
     * @param
     * @return List of all Products in database
     */
    public List<Products> GetAllProducts(Products products)
    {
        try
        {
            if (products.equals(null))
            {
                return productsRepository.findAll();
            }
            else
            {
                Example<Products> productsExample = Example.of(products);
                return productsRepository.findAll(productsExample);
            }
        }
        catch(Exception e)
        {
            throw new ServiceUnavailable(e);
        }
    }
    /**
     * Search Products by id in database
     * @param id - Id of Product to lookup
     * @return - The Product belonging to the Id or a 404 if not found
     */
    public Products GetProductById(Long id)
    {
        try
        {
            Products productsLookUpRequest = productsRepository.findById(id).orElse(null);
            if(productsLookUpRequest != null)
            {
                return productsLookUpRequest;
            }
        }
        catch (Exception e)
        {
            throw new ServiceUnavailable(e);
        }
        throw new ResourceNotFound("Could not locate a Product with the id: " + id);
    }
    /**
     * Deletes a Product from the database by Id
     * @param id - Id of the Product to delete
     */
    public void DeleteProductById(Long id)
    {
        try
        {
            if(productsRepository.existsById(id))
            {
                productsRepository.deleteById(id);
                return;
            }
        }
        catch(Exception e)
        {
            throw new ServiceUnavailable(e);
        }
        // if we made it down to this point, we did not find the Vaccination
        throw new ResourceNotFound("Could not locate a Product with the id: " + id);
    }


    /**
     * Updates the database information for an existing Products. Does not insert a record if the
     * id does not exist.
     * @param id - the id of the Product to update.
     * @param products - the supplied Product information to update the database record.
     * @return - the updated Product or a 404 if the Product was not found
     */
    public Products UpdateProductById(Long id,Products products)
    {
        if(!products.getId().equals(id))
        {
            throw new BadDataResponse("Product ID must match the ID specified in the URL");
        }
        // check if price is valid
        if(products.getPrice().scale() != 2){
            throw new BadDataResponse("Format of price is not correct");//BAD_REQUEST_PRICE);
        }

        try
        {
            Products productsFromDb = productsRepository.findById(id).orElse(null);
            if(productsFromDb != null)
            {
                // if the given sku is not changed or given sku is not same as different product's sku, update this product
              // if(productsFromDb.getSku().equals(products.getSku()) || !productsRepository.existsBySku(products.getSku())){

                    return productsRepository.save(products);
            }
        }
        catch (Exception e)
        {
            throw new ServiceUnavailable(e);
        }
        // if we made it down to this point, we did not find the Vaccination
        throw new ResourceNotFound("Could not locate a Product with the id: " + id);
    }
    /**
     * Writes a new product to the database.
     *
     * @param products - the Product to write.
     * @return - the new Product
     */
    public Products AddProduct(Products products)
    {
        if(products.getPrice().scale() != 2){
            throw new BadDataResponse("Format of price is not correct");//BAD_REQUEST_PRICE);
        }
        try
        {
            //check if product already exists
            skuAlreadyExists = productsRepository.existsBySku(products.getSku());
            if (!skuAlreadyExists)
            {
                return productsRepository.save(products);
            }
        }
        catch (Exception e)
        {
            throw new ServiceUnavailable(e);
        }
        throw new Conflict(SKU_CONFLICT);
    }










}//end class
