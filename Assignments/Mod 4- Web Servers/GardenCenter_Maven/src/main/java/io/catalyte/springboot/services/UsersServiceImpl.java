package io.catalyte.springboot.services;


import io.catalyte.springboot.entities.Customers;
import io.catalyte.springboot.entities.Users;
import io.catalyte.springboot.exceptions.*;
import io.catalyte.springboot.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;


import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static io.catalyte.springboot.constants.StringConstants.*;

@Service
public class UsersServiceImpl implements UsersService
{
    @Autowired
    private UsersRepository usersRepository;
    private Users users;
    boolean emailAlreadyExists;


    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    /**
     * Queries all fields of Users
     * @param users
     * @return List of Users based on field Params provided.
     */
    public List<Users> GetAllUsers(Users users)
    {
        try
        {
            if (users.equals(null))
            {
                return usersRepository.findAll();
            }
            else
            {
                Example<Users> usersExample = Example.of(users);
                return usersRepository.findAll(usersExample);
            }
        }
        catch(Exception e)
        {
            throw new ServiceUnavailable(e);
        }
    }

    /**
     * Gets a users by provided Id
     * @param id
     * @return the user associated with the Id.
     */
    public Users GetUserById(Long id)
    {

        try
        {
            Users usersLookUpRequest = usersRepository.findById(id).orElse(null);
            if(usersLookUpRequest != null)
            {
                return usersLookUpRequest;
            }
        }
        catch (Exception e)
        {
            throw new ServiceUnavailable(e);
        }
        throw new ResourceNotFound("Could not locate a User with the id: " + id);
    }

    /**
     * Creates a new User
     * @param id
     * @returns  A new user
     */
    public void DeleteUserById(Long id)
    {

        try
        {
            if(usersRepository.existsById(id))
            {
                usersRepository.deleteById(id);
                return;
            }
        }
        catch(Exception e)
        {
            throw new ServiceUnavailable(e);
        }
        // if we made it down to this point, we did not find the Vaccination
        throw new ResourceNotFound("Could not locate a User with the id: " + id);
    }
    /**
     * Updates the database information for an existing User. Does not insert a record if the
     * id does not exist.
     * @param id - the id of the User to update.
     * @param users - the supplied User information to update the database record.
     * @return - the updated user or a 404 if the user was not found
     */
    public Users UpdateUserById(Long id,Users users) {
        if (!users.getId().equals(id)) {
            throw new BadDataResponse("User ID must match the ID specified in the URL");
        }
        //if password > 8, then throw error
        int passwordLength = users.getPassword().length();
        if (passwordLength < 8)
        {
            throw new Conflict(BAD_REQUEST_PASSWORD);
        }

        try {
            Users usersFromDb = usersRepository.findById(id).orElse(null);
            if (usersFromDb != null) {
                //check if email already exists
                //**check email doesn't work. Says can't find Id??
                emailAlreadyExists = usersRepository.existsByEmail(users.getEmail());
                if (!emailAlreadyExists) {
                    return usersRepository.save(users);
                }
            }
        } catch (Exception e) {
            throw new ServiceUnavailable(e);
        }
        // if we made it down to this point, we did not find the User
        throw new ResourceNotFound("Could not locate a Users with the id: " + id);

        }

    /**
     * Writes a new user to the database.
     *
     * @param users- the User to write.
     * @return - the new User
     */
    public Users addUser(Users users)
    {
        //if password > 8, then throw error
        int passwordLength = users.getPassword().length();
        System.out.println(passwordLength);
        if (passwordLength < 8)
        {
            throw new BadRequest(BAD_REQUEST_PASSWORD);
        }
        try
        {
            //check if email already exists
            emailAlreadyExists = usersRepository.existsByEmail(users.getEmail());
            if(!emailAlreadyExists){
                return usersRepository.save(users);
            }

        }
        catch (Exception e)
        {

            throw new ServiceUnavailable(e);
        }
        //if made it to this point, email in not unique
        throw new Conflict(EMAIL_CONFLICT);


    }


} // end class
