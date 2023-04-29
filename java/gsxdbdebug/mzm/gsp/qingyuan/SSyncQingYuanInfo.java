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
/*    */ public class SSyncQingYuanInfo
/*    */   extends __SSyncQingYuanInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12602893;
/*    */   public ArrayList<Long> qing_yuan_role_list;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12602893;
/*    */   }
/*    */   
/*    */ 
/*    */   public SSyncQingYuanInfo()
/*    */   {
/* 33 */     this.qing_yuan_role_list = new ArrayList();
/*    */   }
/*    */   
/*    */   public SSyncQingYuanInfo(ArrayList<Long> _qing_yuan_role_list_) {
/* 37 */     this.qing_yuan_role_list = _qing_yuan_role_list_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.compact_uint32(this.qing_yuan_role_list.size());
/* 46 */     for (Long _v_ : this.qing_yuan_role_list) {
/* 47 */       _os_.marshal(_v_.longValue());
/*    */     }
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 55 */       long _v_ = _os_.unmarshal_long();
/* 56 */       this.qing_yuan_role_list.add(Long.valueOf(_v_));
/*    */     }
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof SSyncQingYuanInfo)) {
/* 67 */       SSyncQingYuanInfo _o_ = (SSyncQingYuanInfo)_o1_;
/* 68 */       if (!this.qing_yuan_role_list.equals(_o_.qing_yuan_role_list)) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += this.qing_yuan_role_list.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.qing_yuan_role_list).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingyuan\SSyncQingYuanInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */