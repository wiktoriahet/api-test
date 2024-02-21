package pl.hetman.wiktoria.solvd.app.api.author;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}api/v1/Authors/", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/authors/_post/rq.json")
@ResponseTemplatePath(path = "api/authors/_post/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PostAuthor extends AbstractApiMethodV2 {

    public PostAuthor() {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }

}
