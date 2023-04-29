/*    */ package mzm.gsp.sworn;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.sworn.main.PChangeSwornNameReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CChangeSwornNameReq
/*    */   extends __CChangeSwornNameReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12597794;
/*    */   public String name1;
/*    */   public String name2;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleid, new PChangeSwornNameReq(roleid, this.name1, this.name2));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12597794;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CChangeSwornNameReq()
/*    */   {
/* 36 */     this.name1 = "";
/* 37 */     this.name2 = "";
/*    */   }
/*    */   
/*    */   public CChangeSwornNameReq(String _name1_, String _name2_) {
/* 41 */     this.name1 = _name1_;
/* 42 */     this.name2 = _name2_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.name1, "UTF-16LE");
/* 51 */     _os_.marshal(this.name2, "UTF-16LE");
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.name1 = _os_.unmarshal_String("UTF-16LE");
/* 57 */     this.name2 = _os_.unmarshal_String("UTF-16LE");
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof CChangeSwornNameReq)) {
/* 67 */       CChangeSwornNameReq _o_ = (CChangeSwornNameReq)_o1_;
/* 68 */       if (!this.name1.equals(_o_.name1)) return false;
/* 69 */       if (!this.name2.equals(_o_.name2)) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.name1.hashCode();
/* 78 */     _h_ += this.name2.hashCode();
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append("T").append(this.name1.length()).append(",");
/* 86 */     _sb_.append("T").append(this.name2.length()).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sworn\CChangeSwornNameReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */