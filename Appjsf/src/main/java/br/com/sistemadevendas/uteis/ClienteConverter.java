package br.com.sistemadevendas.uteis;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.sistemadevendas.model.CategoriaModel;
import br.com.sistemadevendas.model.ClienteModel;

@FacesConverter("clienteConverter")
public class ClienteConverter implements Converter {

	@Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && !value.isEmpty()) {
            return (ClienteModel) uiComponent.getAttributes().get(value);
        }
        return null;
    }

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2 instanceof CategoriaModel) {
			ClienteModel entity = (ClienteModel) arg2;
            if (entity != null && entity instanceof ClienteModel && entity.getCodigo() != null) {
            	arg1.getAttributes().put( entity.getCodigo().toString(), entity);
                return entity.getCodigo().toString();
            }
        }
        return "";
    }
	

}
