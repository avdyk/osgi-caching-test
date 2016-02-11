package com.github.avdyk.osgi.caching.test.command;

import com.github.avdyk.osgi.caching.test.api.DevelopperService;
import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Command(scope = "avdyk", name="cache", description="my description")
public class DevelopperCommand extends OsgiCommandSupport {

    private static final Logger logger = LoggerFactory.getLogger(DevelopperCommand.class);
    private DevelopperService service;

    @Argument(index = 0, name = "departement", description = "Departement", required = true, multiValued = false)
    String departement;

    public DevelopperCommand(DevelopperService service) {
      this.service = service;
    }

    @Override
    protected Object doExecute() throws Exception {
        logger.info("Cache test command with argument: {}", departement);
        final List<String> developpers = service.getDeveloppers(departement);
        System.out.printf("List of the developpers of the %s departement%n", departement);
        for (final String dev : developpers) {
            System.out.printf("%4s%n", dev);
        }
        System.out.println("Thanks.");
        return null;
    }
}
