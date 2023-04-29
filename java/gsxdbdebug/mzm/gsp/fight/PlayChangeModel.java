/*    */ package mzm.gsp.fight;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.pubdata.ModelInfo;
/*    */ 
/*    */ public class PlayChangeModel implements Marshal
/*    */ {
/*    */   public int fighterid;
/*    */   public ModelInfo model;
/*    */   
/*    */   public PlayChangeModel()
/*    */   {
/* 15 */     this.model = new ModelInfo();
/*    */   }
/*    */   
/*    */   public PlayChangeModel(int _fighterid_, ModelInfo _model_) {
/* 19 */     this.fighterid = _fighterid_;
/* 20 */     this.model = _model_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 24 */     if (!this.model._validator_()) return false;
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.marshal(this.fighterid);
/* 30 */     _os_.marshal(this.model);
/* 31 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 35 */     this.fighterid = _os_.unmarshal_int();
/* 36 */     this.model.unmarshal(_os_);
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 41 */     if (_o1_ == this) return true;
/* 42 */     if ((_o1_ instanceof PlayChangeModel)) {
/* 43 */       PlayChangeModel _o_ = (PlayChangeModel)_o1_;
/* 44 */       if (this.fighterid != _o_.fighterid) return false;
/* 45 */       if (!this.model.equals(_o_.model)) return false;
/* 46 */       return true;
/*    */     }
/* 48 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 52 */     int _h_ = 0;
/* 53 */     _h_ += this.fighterid;
/* 54 */     _h_ += this.model.hashCode();
/* 55 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 59 */     StringBuilder _sb_ = new StringBuilder();
/* 60 */     _sb_.append("(");
/* 61 */     _sb_.append(this.fighterid).append(",");
/* 62 */     _sb_.append(this.model).append(",");
/* 63 */     _sb_.append(")");
/* 64 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\PlayChangeModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */