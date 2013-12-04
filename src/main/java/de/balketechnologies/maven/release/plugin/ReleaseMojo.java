package de.balketechnologies.maven.release.plugin;

import org.apache.maven.execution.MavenSession;
import org.apache.maven.model.Plugin;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.BuildPluginManager;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.project.MavenProject;
import org.apache.maven.plugins.annotations.Mojo;
import org.codehaus.plexus.configuration.xml.XmlPlexusConfiguration;

import static org.twdata.maven.mojoexecutor.MojoExecutor.*;
import static org.twdata.maven.mojoexecutor.PlexusConfigurationUtils.toXpp3Dom;

@Mojo(name = "release")
public class ReleaseMojo extends AbstractMojo {
	/**
	 * Plugin to execute.
	 * 
	 * @parameter
	 * @required
	 */
	private Plugin plugin;

	/**
	 * Plugin goal to execute.
	 * 
	 * @parameter
	 * @required
	 */
	private String goal;

	/**
	 * Plugin configuration to use in the execution.
	 * 
	 * @parameter
	 */
	private XmlPlexusConfiguration configuration;

	/**
	 * The project currently being build.
	 * 
	 * @parameter expression="${project}"
	 * @required
	 * @readonly
	 */
	@Component
	private MavenProject mavenProject;

	/**
	 * The current Maven session.
	 * 
	 * @parameter expression="${session}"
	 * @required
	 * @readonly
	 */
	@Component
	private MavenSession mavenSession;

	/**
	 * The Maven BuildPluginManager component.
	 * 
	 * @component
	 * @required
	 */
	@Component
	private BuildPluginManager pluginManager;

	@Override
	public void execute() throws MojoExecutionException, MojoFailureException {
		// TODO remove this example and implement real workflow
		executeMojo(plugin, goal, toXpp3Dom(configuration), executionEnvironment(mavenProject, mavenSession, pluginManager));
	}

}
