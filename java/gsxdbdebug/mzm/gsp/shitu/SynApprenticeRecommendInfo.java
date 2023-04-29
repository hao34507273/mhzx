/*    */ package mzm.gsp.shitu;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SynApprenticeRecommendInfo
/*    */   extends __SynApprenticeRecommendInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12601660;
/*    */   public ShiTuRoleInfoAndModelInfo apprentice_recommend_info;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12601660;
/*    */   }
/*    */   
/*    */ 
/*    */   public SynApprenticeRecommendInfo()
/*    */   {
/* 33 */     this.apprentice_recommend_info = new ShiTuRoleInfoAndModelInfo();
/*    */   }
/*    */   
/*    */   public SynApprenticeRecommendInfo(ShiTuRoleInfoAndModelInfo _apprentice_recommend_info_) {
/* 37 */     this.apprentice_recommend_info = _apprentice_recommend_info_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     if (!this.apprentice_recommend_info._validator_()) return false;
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.apprentice_recommend_info);
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 51 */     this.apprentice_recommend_info.unmarshal(_os_);
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof SynApprenticeRecommendInfo)) {
/* 61 */       SynApprenticeRecommendInfo _o_ = (SynApprenticeRecommendInfo)_o1_;
/* 62 */       if (!this.apprentice_recommend_info.equals(_o_.apprentice_recommend_info)) return false;
/* 63 */       return true;
/*    */     }
/* 65 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 69 */     int _h_ = 0;
/* 70 */     _h_ += this.apprentice_recommend_info.hashCode();
/* 71 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 75 */     StringBuilder _sb_ = new StringBuilder();
/* 76 */     _sb_.append("(");
/* 77 */     _sb_.append(this.apprentice_recommend_info).append(",");
/* 78 */     _sb_.append(")");
/* 79 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\SynApprenticeRecommendInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */