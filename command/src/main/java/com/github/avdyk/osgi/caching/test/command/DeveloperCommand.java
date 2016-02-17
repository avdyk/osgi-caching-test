package com.github.avdyk.osgi.caching.test.command;

import com.github.avdyk.osgi.caching.test.api.DeveloperService;
import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Command(scope = "avdyk", name="cache", description="my description")
public class DeveloperCommand extends OsgiCommandSupport {

    private static final Logger logger = LoggerFactory.getLogger(DeveloperCommand.class);
    private DeveloperService service;

    @Argument(index = 0, name = "department", description = "Department", required = true, multiValued = false)
    String department;

    public DeveloperCommand(DeveloperService service) {
      this.service = service;
    }

    @Override
    protected Object doExecute() throws Exception {
        logger.info("Cache test command with argument: {}", department);
        final List<String> developers = service.getDevelopers(department);
        System.out.printf("List of the developers of the %s department%n", department);
        for (final String dev : developers) {
            System.out.printf("%4s%n", dev);
        }
        System.out.println("Thanks.");
        return null;
    }
}
