package dmit2015.faces;

import dmit2015.entity.Department;
import dmit2015.persistence.HumanResourcesRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.ConverterException;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ApplicationScoped
@FacesConverter(value = "departmentConverter", managed = true)
public class DepartmentConverter implements Converter<Department> {

    @Inject
    private HumanResourcesRepository hrRepository;

    @Override
    public Department getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if (s != null && !s.isBlank()) {
            try {
                Short departmentId = Short.parseShort(s);
                return hrRepository.departmentById(departmentId);
            }  catch (NumberFormatException e) {
                throw new ConverterException(new FacesMessage(e.getMessage()));
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Department department) {
        if (department != null) {
            return department.getId().toString();
        }
        return "";
    }
}
