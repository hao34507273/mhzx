/*    */ package mzm.gsp.shitu;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
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
/*    */ public class SynMasterRecommendInfos
/*    */   extends __SynMasterRecommendInfos__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12601661;
/*    */   public long sessionid;
/*    */   public ArrayList<ShiTuRoleInfoAndModelInfo> all_master_recommend_infos;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12601661;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SynMasterRecommendInfos()
/*    */   {
/* 34 */     this.all_master_recommend_infos = new ArrayList();
/*    */   }
/*    */   
/*    */   public SynMasterRecommendInfos(long _sessionid_, ArrayList<ShiTuRoleInfoAndModelInfo> _all_master_recommend_infos_) {
/* 38 */     this.sessionid = _sessionid_;
/* 39 */     this.all_master_recommend_infos = _all_master_recommend_infos_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     for (ShiTuRoleInfoAndModelInfo _v_ : this.all_master_recommend_infos)
/* 44 */       if (!_v_._validator_()) return false;
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.sessionid);
/* 50 */     _os_.compact_uint32(this.all_master_recommend_infos.size());
/* 51 */     for (ShiTuRoleInfoAndModelInfo _v_ : this.all_master_recommend_infos) {
/* 52 */       _os_.marshal(_v_);
/*    */     }
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     this.sessionid = _os_.unmarshal_long();
/* 59 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 60 */       ShiTuRoleInfoAndModelInfo _v_ = new ShiTuRoleInfoAndModelInfo();
/* 61 */       _v_.unmarshal(_os_);
/* 62 */       this.all_master_recommend_infos.add(_v_);
/*    */     }
/* 64 */     if (!_validator_()) {
/* 65 */       throw new VerifyError("validator failed");
/*    */     }
/* 67 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 71 */     if (_o1_ == this) return true;
/* 72 */     if ((_o1_ instanceof SynMasterRecommendInfos)) {
/* 73 */       SynMasterRecommendInfos _o_ = (SynMasterRecommendInfos)_o1_;
/* 74 */       if (this.sessionid != _o_.sessionid) return false;
/* 75 */       if (!this.all_master_recommend_infos.equals(_o_.all_master_recommend_infos)) return false;
/* 76 */       return true;
/*    */     }
/* 78 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 82 */     int _h_ = 0;
/* 83 */     _h_ += (int)this.sessionid;
/* 84 */     _h_ += this.all_master_recommend_infos.hashCode();
/* 85 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 89 */     StringBuilder _sb_ = new StringBuilder();
/* 90 */     _sb_.append("(");
/* 91 */     _sb_.append(this.sessionid).append(",");
/* 92 */     _sb_.append(this.all_master_recommend_infos).append(",");
/* 93 */     _sb_.append(")");
/* 94 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\SynMasterRecommendInfos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */