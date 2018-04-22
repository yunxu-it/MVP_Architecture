package cn.winxo.mvp.data.entity.remote;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * @author lxlong
 * @date 22/04/2018
 * @desc
 */
public class GankBase {

  @SerializedName("error") private boolean error;
  @SerializedName("results") private List<Gank> results;

  public boolean isError() {
    return error;
  }

  public void setError(boolean error) {
    this.error = error;
  }

  public List<Gank> getResults() {
    return results;
  }

  public void setResults(List<Gank> results) {
    this.results = results;
  }
}
