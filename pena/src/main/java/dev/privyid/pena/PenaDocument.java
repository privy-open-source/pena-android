package dev.privyid.pena;

import org.jetbrains.annotations.Nullable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class PenaDocument {
    private String url;
    @Nullable
    private String privyId;
    @Nullable
    private Boolean visibility;
    @Nullable
    private Boolean debug;
    @Nullable
    private String lang;
    @Nullable
    private Placement signature;
    @Nullable
    private Object needScrollTo;
    @Nullable
    private Function1<Payload, Unit> onAfterAction;

    public PenaDocument(String url) {
        this.setUrl(url);
    }

    public Function1<Payload, Unit> getOnAfterAction() {
        return onAfterAction;
    }

    public String getUrl() {
        return url;
    }

    public PenaDocument setUrl(String url) {
        this.url = url;

        return this;
    }

    public String getPrivyId() {
        return privyId;
    }

    public PenaDocument setPrivyId(String privyId) {
        this.privyId = privyId;

        return this;
    }

    public Boolean getVisibility() {
        return visibility;
    }

    public PenaDocument setVisibility(Boolean visibility) {
        this.visibility = visibility;

        return this;
    }

    public Boolean getDebug() {
        return debug;
    }

    public PenaDocument setDebug(Boolean debug) {
        this.debug = debug;

        return this;
    }

    public String getLang() {
        return lang;
    }

    public PenaDocument setLang(String lang) {
        this.lang = lang;

        return this;
    }

    public Placement getSignature() {
        return signature;
    }

    public PenaDocument setSignature(Placement signature) {
        this.signature = signature;

        return this;
    }

    public PenaDocument setOnAfterAction(Function1<Payload, Unit> onAfterAction) {
        this.onAfterAction = onAfterAction;

        return this;
    }

    public String getNeedScrollTo () {
        return this.needScrollTo.toString();
    }

    public PenaDocument setNeedScrollTo (Number needScrollTo) {
        this.needScrollTo = needScrollTo;

        return this;
    }

    public PenaDocument setNeedScrollTo (String needScrollTo) {
        this.needScrollTo = needScrollTo;

        return this;
    }
}
