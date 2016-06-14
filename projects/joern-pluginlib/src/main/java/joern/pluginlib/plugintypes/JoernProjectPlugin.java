package joern.pluginlib.plugintypes;

import joern.pluginlib.connectors.JoernProjectConnector;
import octopus.lib.plugintypes.OctopusProjectPlugin;

public class JoernProjectPlugin extends OctopusProjectPlugin {

	public JoernProjectPlugin()
	{
		setProjectConnector(new JoernProjectConnector());
	}
}