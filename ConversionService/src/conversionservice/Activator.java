package conversionservice;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		ConversionService service = new ConversionServiceImp();
		ServiceRegistration registration = context.registerService(
				ConversionService.class.getName(), service, new Hashtable<String, Object>());
		System.out.println("Service registered: ConversionService!!!!");
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}
