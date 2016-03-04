package rtg.world.gen.terrain.atg;

import rtg.util.CellNoise;
import rtg.util.OpenSimplexNoise;
import rtg.world.gen.terrain.TerrainBase;

public class TerrainATGRockySteppe extends TerrainBase
{

    public TerrainATGRockySteppe()
    {

    }

    @Override
    public float generateNoise(OpenSimplexNoise simplex, CellNoise cell, int x, int y, float border, float river)
    {

        float floNoise;
        float st = (simplex.noise2(x / 160f, y / 160f) + 0.38f) * 10f * river;
        st = st < 0.2f ? 0.2f : st;

        float h = simplex.noise2(x / 60f, y / 60f) * st * 2f;
        h = h > 0f ? -h : h;
        h += st;
        h *= h / 200f;
        h += st;

        floNoise = 63f + h;

        return floNoise;
    }
}
