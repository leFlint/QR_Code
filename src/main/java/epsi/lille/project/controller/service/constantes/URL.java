package epsi.lille.project.controller.service.constantes;

public class URL {

	public static final String MANAGEMENT_BASE_ROOT = "/management";
	static final String REDIRECTIONS_BASE_ROOT = "/redirection";
	static final String COMPTEUR_DE_LIKES_BASE_ROOT = "/compteurDeLike";

	public static final String REDIRECTIONS_MANAGEMENT_ROOT = MANAGEMENT_BASE_ROOT + "/"
			+ REDIRECTIONS_BASE_ROOT;

	public static final String REDIRECTIONS_LIST = REDIRECTIONS_MANAGEMENT_ROOT + "/list";
	public static final String REDIRECTIONS_CREATE = REDIRECTIONS_MANAGEMENT_ROOT
			+ "/form";

	public static final String COMPTEUR_DE_LIKES_MANAGEMENT_ROOT = MANAGEMENT_BASE_ROOT
			+ "/" + COMPTEUR_DE_LIKES_BASE_ROOT;

	public static final String COMPTEUR_DE_LIKES_LIST = COMPTEUR_DE_LIKES_MANAGEMENT_ROOT
			+ "/list";
	public static final String COMPTEUR_DE_LIKES_CREATE = COMPTEUR_DE_LIKES_MANAGEMENT_ROOT
			+ "/form";

	public static final String REDIRECTIONS_VIEW_URL = REDIRECTIONS_BASE_ROOT
			+ "/view/{id}";
	public static final String COMPTEUR_DE_LIKES_VIEW_URL = COMPTEUR_DE_LIKES_BASE_ROOT
			+ "/view/{id}";
	public static final String COMPTEUR_DE_LIKES_DO_LIKE_URL = COMPTEUR_DE_LIKES_BASE_ROOT
			+ "/like/{id}";

}
