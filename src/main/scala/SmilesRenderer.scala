import gitbucket.core.controller.Context
import gitbucket.core.plugin.{RenderRequest, Renderer}
import gitbucket.core.service.RepositoryService.RepositoryInfo
import gitbucket.core.view.helpers.markdown
import play.twirl.api.Html

class SmilesRenderer extends Renderer {

  def render(request: RenderRequest): Html = {
    import request._
    Html(toHtml(fileContent)(context))
  }

  def toHtml(fileContent: String)(implicit context: Context): String = {
    val smilesInput = fileContent.trim.stripLineEnd
    s"""
       |<div id="canvasBase" style="width: 100%; height: 600px"><canvas id="smiles-canvas"></canvas></div>
       |<script src="https://unpkg.com/smiles-drawer@1.0.10/dist/smiles-drawer.min.js"></script>
       |<script>
       |  function renderSmiles () {
       |    let div = document.getElementById("canvasBase")
       |    let options = {width: div.offsetWidth};
       |    let smilesDrawer = new SmilesDrawer.Drawer(options);
       |    SmilesDrawer.parse('$smilesInput', function(tree) {
       |      smilesDrawer.draw(tree, "smiles-canvas", "light", false);
       |    });
       |  }
       |  window.onload = renderSmiles();
       |</script>
       |""".stripMargin
  }

  def shutdown(): Unit = {
  }

}
