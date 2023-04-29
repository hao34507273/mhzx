/*    */ package mzm.gsp.task;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CRefreshTaskSet
/*    */   extends __CRefreshTaskSet__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12592133;
/*    */   public int npcid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 17 */     long roleId = Role.getRoleId(this);
/* 18 */     if (roleId < 0L) {}
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12592133;
/*    */   }
/*    */   
/*    */ 
/*    */   public CRefreshTaskSet() {}
/*    */   
/*    */ 
/*    */   public CRefreshTaskSet(int _npcid_)
/*    */   {
/* 38 */     this.npcid = _npcid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.npcid);
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 51 */     this.npcid = _os_.unmarshal_int();
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof CRefreshTaskSet)) {
/* 61 */       CRefreshTaskSet _o_ = (CRefreshTaskSet)_o1_;
/* 62 */       if (this.npcid != _o_.npcid) return false;
/* 63 */       return true;
/*    */     }
/* 65 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 69 */     int _h_ = 0;
/* 70 */     _h_ += this.npcid;
/* 71 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 75 */     StringBuilder _sb_ = new StringBuilder();
/* 76 */     _sb_.append("(");
/* 77 */     _sb_.append(this.npcid).append(",");
/* 78 */     _sb_.append(")");
/* 79 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CRefreshTaskSet _o_) {
/* 83 */     if (_o_ == this) return 0;
/* 84 */     int _c_ = 0;
/* 85 */     _c_ = this.npcid - _o_.npcid;
/* 86 */     if (0 != _c_) return _c_;
/* 87 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\CRefreshTaskSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */