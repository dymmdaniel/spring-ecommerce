package com.dm.ecommerce.user_service.controller;

import com.dm.ecommerce.common_service.controller.CommonMongoController;
import com.dm.ecommerce.user_service.model.*;
import com.dm.ecommerce.user_service.service.CityService;
import com.dm.ecommerce.user_service.service.CountryService;
import com.dm.ecommerce.user_service.service.StateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/country")
public class CountryController extends CommonMongoController<Country, CountryService> {

}
