/*    */ package mzm.gsp.qingyuan;
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
/*    */ 
/*    */ public class SGetQingYuanInfo
/*    */   extends __SGetQingYuanInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12602881;
/*    */   public ArrayList<QingYuanRoleInfo> qing_yuan_role_list_info;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12602881;
/*    */   }
/*    */   
/*    */ 
/*    */   public SGetQingYuanInfo()
/*    */   {
/* 33 */     this.qing_yuan_role_list_info = new ArrayList();
/*    */   }
/*    */   
/*    */   public SGetQingYuanInfo(ArrayList<QingYuanRoleInfo> _qing_yuan_role_list_info_) {
/* 37 */     this.qing_yuan_role_list_info = _qing_yuan_role_list_info_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     for (QingYuanRoleInfo _v_ : this.qing_yuan_role_list_info)
/* 42 */       if (!_v_._validator_()) return false;
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.compact_uint32(this.qing_yuan_role_list_info.size());
/* 48 */     for (QingYuanRoleInfo _v_ : this.qing_yuan_role_list_info) {
/* 49 */       _os_.marshal(_v_);
/*    */     }
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 56 */       QingYuanRoleInfo _v_ = new QingYuanRoleInfo();
/* 57 */       _v_.unmarshal(_os_);
/* 58 */       this.qing_yuan_role_list_info.add(_v_);
/*    */     }
/* 60 */     if (!_validator_()) {
/* 61 */       throw new VerifyError("validator failed");
/*    */     }
/* 63 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 67 */     if (_o1_ == this) return true;
/* 68 */     if ((_o1_ instanceof SGetQingYuanInfo)) {
/* 69 */       SGetQingYuanInfo _o_ = (SGetQingYuanInfo)_o1_;
/* 70 */       if (!this.qing_yuan_role_list_info.equals(_o_.qing_yuan_role_list_info)) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.qing_yuan_role_list_info.hashCode();
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.qing_yuan_role_list_info).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingyuan\SGetQingYuanInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */