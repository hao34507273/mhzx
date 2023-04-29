/*    */ package mzm.gsp.qmhw;
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
/*    */ public class SBrocastGetTitleRoles
/*    */   extends __SBrocastGetTitleRoles__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12601873;
/*    */   public ArrayList<String> rolename;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12601873;
/*    */   }
/*    */   
/*    */ 
/*    */   public SBrocastGetTitleRoles()
/*    */   {
/* 33 */     this.rolename = new ArrayList();
/*    */   }
/*    */   
/*    */   public SBrocastGetTitleRoles(ArrayList<String> _rolename_) {
/* 37 */     this.rolename = _rolename_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.compact_uint32(this.rolename.size());
/* 46 */     for (String _v_ : this.rolename) {
/* 47 */       _os_.marshal(_v_, "UTF-16LE");
/*    */     }
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 55 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/* 56 */       this.rolename.add(_v_);
/*    */     }
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof SBrocastGetTitleRoles)) {
/* 67 */       SBrocastGetTitleRoles _o_ = (SBrocastGetTitleRoles)_o1_;
/* 68 */       if (!this.rolename.equals(_o_.rolename)) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += this.rolename.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.rolename).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qmhw\SBrocastGetTitleRoles.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */