import javax.servlet.ServletContext
import gitbucket.core.plugin.{PluginRegistry}
import gitbucket.core.service.SystemSettingsService
import gitbucket.core.service.SystemSettingsService.SystemSettings
import io.github.gitbucket.solidbase.model.Version

import scala.util.Try

class Plugin extends gitbucket.core.plugin.Plugin {
  override val pluginId: String = "Smiles"
  override val pluginName: String = "Smiles renderer Plugin"
  override val description: String = "Rendering Smiles files."
  override val versions: List[Version] = List(
    new Version("1.0.0"),
  )

  private[this] var renderer: Option[SmilesRenderer] = None

  override def initialize(registry: PluginRegistry, context: ServletContext, settings: SystemSettingsService.SystemSettings): Unit = {
    val test = Try{ new SmilesRenderer() }
    val smiles = test.get
    registry.addRenderer("smiles", smiles)
    renderer = Option(smiles)
    super.initialize(registry, context, settings)
  }

  override def shutdown(registry: PluginRegistry, context: ServletContext, settings: SystemSettings): Unit = {
    renderer.map(r => r.shutdown())
  }

}