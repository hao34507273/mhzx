/*    */ package mzm.gsp.task;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.task.main.PShareSuc;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CShareSuc
/*    */   extends __CShareSuc__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12592153;
/*    */   public int shareid;
/*    */   public int sharecount;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 0L) {
/* 21 */       return;
/*    */     }
/* 23 */     Role.addRoleProcedure(roleId, new PShareSuc(roleId, this.shareid, this.sharecount));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12592153;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CShareSuc() {}
/*    */   
/*    */ 
/*    */   public CShareSuc(int _shareid_, int _sharecount_)
/*    */   {
/* 41 */     this.shareid = _shareid_;
/* 42 */     this.sharecount = _sharecount_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.shareid);
/* 51 */     _os_.marshal(this.sharecount);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.shareid = _os_.unmarshal_int();
/* 57 */     this.sharecount = _os_.unmarshal_int();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof CShareSuc)) {
/* 67 */       CShareSuc _o_ = (CShareSuc)_o1_;
/* 68 */       if (this.shareid != _o_.shareid) return false;
/* 69 */       if (this.sharecount != _o_.sharecount) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.shareid;
/* 78 */     _h_ += this.sharecount;
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.shareid).append(",");
/* 86 */     _sb_.append(this.sharecount).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CShareSuc _o_) {
/* 92 */     if (_o_ == this) return 0;
/* 93 */     int _c_ = 0;
/* 94 */     _c_ = this.shareid - _o_.shareid;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     _c_ = this.sharecount - _o_.sharecount;
/* 97 */     if (0 != _c_) return _c_;
/* 98 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\CShareSuc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */