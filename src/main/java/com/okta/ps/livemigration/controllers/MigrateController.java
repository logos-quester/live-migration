package com.okta.ps.livemigration.controllers;

import com.okta.ps.livemigration.requests.AuthnRequest;
import com.okta.sdk.client.Client;
import com.okta.sdk.client.ClientBuilder;
import com.okta.sdk.client.Clients;
import com.okta.sdk.resource.user.UserBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@RestController("/migrate")
public class MigrateController {

    @PostMapping
    public HttpEntity<String> primaryAuthn(@RequestBody AuthnRequest authn, @RequestHeader HttpHeaders headers)
    {
        //getOktaUser
        //checkMigrationFlag
        //if migratedFlag == true
            //return 401 (similar to failed auth at Okta)
        //else
            //validatePasswordAtExistingRepo
            //if password invalid
                //return 401 (similar to failed auth at Okta)
            //else
                //setOktaPasswordToCurrentPassword
                //return 204










        //Okta Client Examples
        //client settings defined here: https://github.com/okta/okta-sdk-java#client-configuration
        ClientBuilder builder = Clients.builder();
        Client client = builder.build();

        //get profile attribute
        String firstName = client.getUser(authn.getUsername()).getProfile().getFirstName();
        //client.getUser(authn.getUsername()).getProfile().get("migratedFlag");

        //set password
        UserBuilder.instance().setPassword(authn.getPassword().toCharArray());




        //Existing repo check
        if(true == validateExistingCredentialsAgainstExistingRepo(authn.getUsername(), authn.getPassword()))
        {

        }
        else
        {

        }





        //RestTemplate Example
//        RestTemplate restTemplate = new RestTemplate();
//        String authnResourceUrl = "https://tkirk.oktapreview.com/api/v1/authn";
//        HttpEntity<AuthnRequest> entity = new HttpEntity<>(authn);
//
//        ResponseEntity<String> respons = restTemplate.postForEntity(authnResourceUrl,entity,String.class);
//
//
//
//        return respons;
        return null;
    }

    private boolean validateExistingCredentialsAgainstExistingRepo(String username, String password)
    {

        return false;
    }
}
