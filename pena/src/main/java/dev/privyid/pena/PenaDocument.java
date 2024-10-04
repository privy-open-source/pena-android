package dev.privyid.pena;

import org.jetbrains.annotations.Nullable;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class PenaDocument {
    private final String url;
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
        this.url = url;
    }


    public String getUrl() {

        return this.url;
    }

    @Nullable
    public String getPrivyId() {

        return this.privyId;
    }

    public PenaDocument setPrivyId(String privyId) {
        this.privyId = privyId;

        return this;
    }

    @Nullable
    public Boolean getVisibility() {

        return visibility;
    }

    public PenaDocument setVisibility(Boolean visibility) {
        this.visibility = visibility;

        return this;
    }

    @Nullable
    public Boolean getDebug() {

        return this.debug;
    }

    public PenaDocument setDebug(Boolean debug) {
        this.debug = debug;

        return this;
    }

    @Nullable
    public String getLang() {

        return this.lang;
    }

    public PenaDocument setLang(String lang) {
        this.lang = lang;

        return this;
    }

    @Nullable
    public Placement getSignature() {

        return this.signature;
    }

    public PenaDocument setSignature(Placement signature) {
        this.signature = signature;

        return this;
    }

    @Nullable
    public Function1<Payload, Unit> getOnAfterAction() {

        return this.onAfterAction;
    }

    public PenaDocument setOnAfterAction(Function1<Payload, Unit> onAfterAction) {
        this.onAfterAction = onAfterAction;

        return this;
    }

    @Nullable
    public String getNeedScrollTo() {
        if (this.needScrollTo != null) {
            return this.needScrollTo.toString();
        }

        return null;
    }

    public PenaDocument setNeedScrollTo(Number needScrollTo) {
        this.needScrollTo = needScrollTo;

        return this;
    }

    public PenaDocument setNeedScrollTo(String needScrollTo) {
        this.needScrollTo = needScrollTo;

        return this;
    }
}
