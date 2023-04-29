/*    */ package mzm.gsp.zoo;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.zoo.main.PCAnimalRename;
/*    */ 
/*    */ 
/*    */ public class CAnimalRename
/*    */   extends __CAnimalRename__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12615439;
/*    */   public long animalid;
/*    */   public Octets name;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 1L) {
/* 21 */       return;
/*    */     }
/* 23 */     String tmpName = null;
/*    */     try
/*    */     {
/* 26 */       tmpName = this.name.getString("UTF-8");
/*    */     }
/*    */     catch (Exception e) {}
/*    */     
/*    */ 
/*    */ 
/* 32 */     Role.addRoleProcedure(roleId, new PCAnimalRename(roleId, this.animalid, tmpName));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 40 */     return 12615439;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CAnimalRename()
/*    */   {
/* 47 */     this.name = new Octets();
/*    */   }
/*    */   
/*    */   public CAnimalRename(long _animalid_, Octets _name_) {
/* 51 */     this.animalid = _animalid_;
/* 52 */     this.name = _name_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 56 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 60 */     _os_.marshal(this.animalid);
/* 61 */     _os_.marshal(this.name);
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 66 */     this.animalid = _os_.unmarshal_long();
/* 67 */     this.name = _os_.unmarshal_Octets();
/* 68 */     if (!_validator_()) {
/* 69 */       throw new VerifyError("validator failed");
/*    */     }
/* 71 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 75 */     if (_o1_ == this) return true;
/* 76 */     if ((_o1_ instanceof CAnimalRename)) {
/* 77 */       CAnimalRename _o_ = (CAnimalRename)_o1_;
/* 78 */       if (this.animalid != _o_.animalid) return false;
/* 79 */       if (!this.name.equals(_o_.name)) return false;
/* 80 */       return true;
/*    */     }
/* 82 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 86 */     int _h_ = 0;
/* 87 */     _h_ += (int)this.animalid;
/* 88 */     _h_ += this.name.hashCode();
/* 89 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 93 */     StringBuilder _sb_ = new StringBuilder();
/* 94 */     _sb_.append("(");
/* 95 */     _sb_.append(this.animalid).append(",");
/* 96 */     _sb_.append("B").append(this.name.size()).append(",");
/* 97 */     _sb_.append(")");
/* 98 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zoo\CAnimalRename.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */