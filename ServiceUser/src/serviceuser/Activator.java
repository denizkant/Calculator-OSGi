package serviceuser;

import conversionservice.ConversionService;
import java.awt.EventQueue;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator  implements  BundleActivator {

	private static BundleContext context;

    private Calculator calculator;
    private ConversionService conversionService;
	
	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		
		
		
		System.out.println("Activated!!!!!!!!");
		
		ServiceReference<?> reference = context.getServiceReference(ConversionService.class.getName());
			
		if (reference != null) 
		{
		
			conversionService = (ConversionService) context.getService(reference);	
		}
		
		
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CalculatorUI frame = new CalculatorUI(conversionService);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}
