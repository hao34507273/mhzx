/*    */ package mzm.gsp.item;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.item.main.PReNameStorage;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CReNameStorage
/*    */   extends __CReNameStorage__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584807;
/*    */   public int storageid;
/*    */   public String name;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleid, new PReNameStorage(roleid, this.name, this.storageid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 30 */     return 12584807;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CReNameStorage()
/*    */   {
/* 37 */     this.name = "";
/*    */   }
/*    */   
/*    */   public CReNameStorage(int _storageid_, String _name_) {
/* 41 */     this.storageid = _storageid_;
/* 42 */     this.name = _name_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.storageid);
/* 51 */     _os_.marshal(this.name, "UTF-16LE");
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.storageid = _os_.unmarshal_int();
/* 57 */     this.name = _os_.unmarshal_String("UTF-16LE");
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof CReNameStorage)) {
/* 67 */       CReNameStorage _o_ = (CReNameStorage)_o1_;
/* 68 */       if (this.storageid != _o_.storageid) return false;
/* 69 */       if (!this.name.equals(_o_.name)) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.storageid;
/* 78 */     _h_ += this.name.hashCode();
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.storageid).append(",");
/* 86 */     _sb_.append("T").append(this.name.length()).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\CReNameStorage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */