/*    */ package mzm.gsp.sworn;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.sworn.main.PChangeSwornTitleReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CChangeSwornTitleReq
/*    */   extends __CChangeSwornTitleReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12597784;
/*    */   public String title;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleid, new PChangeSwornTitleReq(roleid, this.title));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12597784;
/*    */   }
/*    */   
/*    */ 
/*    */   public CChangeSwornTitleReq()
/*    */   {
/* 35 */     this.title = "";
/*    */   }
/*    */   
/*    */   public CChangeSwornTitleReq(String _title_) {
/* 39 */     this.title = _title_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.title, "UTF-16LE");
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.title = _os_.unmarshal_String("UTF-16LE");
/* 53 */     if (!_validator_()) {
/* 54 */       throw new VerifyError("validator failed");
/*    */     }
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 60 */     if (_o1_ == this) return true;
/* 61 */     if ((_o1_ instanceof CChangeSwornTitleReq)) {
/* 62 */       CChangeSwornTitleReq _o_ = (CChangeSwornTitleReq)_o1_;
/* 63 */       if (!this.title.equals(_o_.title)) return false;
/* 64 */       return true;
/*    */     }
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 70 */     int _h_ = 0;
/* 71 */     _h_ += this.title.hashCode();
/* 72 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 76 */     StringBuilder _sb_ = new StringBuilder();
/* 77 */     _sb_.append("(");
/* 78 */     _sb_.append("T").append(this.title.length()).append(",");
/* 79 */     _sb_.append(")");
/* 80 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sworn\CChangeSwornTitleReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */