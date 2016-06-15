package edu.softserve.zoo.web.controller.rest;

import edu.softserve.zoo.core.model.Warehouse;
import edu.softserve.zoo.service.Service;
import edu.softserve.zoo.service.WarehouseService;
import edu.softserve.zoo.web.annotation.DocsClassDescription;
import edu.softserve.zoo.web.annotation.DocsParamDescription;
import edu.softserve.zoo.web.annotation.DocsTest;
import edu.softserve.zoo.web.dto.WarehouseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static edu.softserve.zoo.web.controller.rest.Routes.WAREHOUSES;

/**
 * RestController implementation for {@link Warehouse} entity.
 *
 * @author Andrii Abramov on 20-May-16.
 */
@RestController
@RequestMapping(WAREHOUSES)
@DocsClassDescription("Warehouse resource")
public class WarehouseRestController extends AbstractRestController<WarehouseDto, Warehouse> {

    @Autowired
    private WarehouseService warehouseService;

    @Override
    protected Service<Warehouse> getService() {
        return warehouseService;
    }

    @DocsTest
    @RequestMapping(method = RequestMethod.GET)
    public List<WarehouseDto> getAll() {
        return super.getAll();
    }

    @DocsTest(pathParameters = "1")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public WarehouseDto getById(@PathVariable @DocsParamDescription("id of warehouse") Long id) {
        return super.getById(id);
    }

    @DocsTest(pathParameters = "1")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public WarehouseDto update(@Valid @RequestBody WarehouseDto dto, @PathVariable @DocsParamDescription("id of warehouse") Long id) {
        return super.update(dto, id);
    }

}