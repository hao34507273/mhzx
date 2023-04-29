/*    */ package mzm.gsp.crossbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class CrossBattleFinalConsts implements Marshal
/*    */ {
/*    */   public GetFinalContext _getfinalcontext;
/*    */   public GetFinalContext_CreatePrepareWorld _getfinalcontext_createprepareworld;
/*    */   public GetFinalContext_CheckPanel _getfinalcontext_checkpanel;
/*    */   
/*    */   public CrossBattleFinalConsts()
/*    */   {
/* 14 */     this._getfinalcontext = new GetFinalContext();
/* 15 */     this._getfinalcontext_createprepareworld = new GetFinalContext_CreatePrepareWorld();
/* 16 */     this._getfinalcontext_checkpanel = new GetFinalContext_CheckPanel();
/*    */   }
/*    */   
/*    */   public CrossBattleFinalConsts(GetFinalContext __getfinalcontext_, GetFinalContext_CreatePrepareWorld __getfinalcontext_createprepareworld_, GetFinalContext_CheckPanel __getfinalcontext_checkpanel_) {
/* 20 */     this._getfinalcontext = __getfinalcontext_;
/* 21 */     this._getfinalcontext_createprepareworld = __getfinalcontext_createprepareworld_;
/* 22 */     this._getfinalcontext_checkpanel = __getfinalcontext_checkpanel_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 26 */     if (!this._getfinalcontext._validator_()) return false;
/* 27 */     if (!this._getfinalcontext_createprepareworld._validator_()) return false;
/* 28 */     if (!this._getfinalcontext_checkpanel._validator_()) return false;
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 33 */     _os_.marshal(this._getfinalcontext);
/* 34 */     _os_.marshal(this._getfinalcontext_createprepareworld);
/* 35 */     _os_.marshal(this._getfinalcontext_checkpanel);
/* 36 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 40 */     this._getfinalcontext.unmarshal(_os_);
/* 41 */     this._getfinalcontext_createprepareworld.unmarshal(_os_);
/* 42 */     this._getfinalcontext_checkpanel.unmarshal(_os_);
/* 43 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 47 */     if (_o1_ == this) return true;
/* 48 */     if ((_o1_ instanceof CrossBattleFinalConsts)) {
/* 49 */       CrossBattleFinalConsts _o_ = (CrossBattleFinalConsts)_o1_;
/* 50 */       if (!this._getfinalcontext.equals(_o_._getfinalcontext)) return false;
/* 51 */       if (!this._getfinalcontext_createprepareworld.equals(_o_._getfinalcontext_createprepareworld)) return false;
/* 52 */       if (!this._getfinalcontext_checkpanel.equals(_o_._getfinalcontext_checkpanel)) return false;
/* 53 */       return true;
/*    */     }
/* 55 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 59 */     int _h_ = 0;
/* 60 */     _h_ += this._getfinalcontext.hashCode();
/* 61 */     _h_ += this._getfinalcontext_createprepareworld.hashCode();
/* 62 */     _h_ += this._getfinalcontext_checkpanel.hashCode();
/* 63 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 67 */     StringBuilder _sb_ = new StringBuilder();
/* 68 */     _sb_.append("(");
/* 69 */     _sb_.append(this._getfinalcontext).append(",");
/* 70 */     _sb_.append(this._getfinalcontext_createprepareworld).append(",");
/* 71 */     _sb_.append(this._getfinalcontext_checkpanel).append(",");
/* 72 */     _sb_.append(")");
/* 73 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\CrossBattleFinalConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */