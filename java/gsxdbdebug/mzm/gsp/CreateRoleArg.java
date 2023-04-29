/*    */ package mzm.gsp;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class CreateRoleArg implements Marshal
/*    */ {
/*    */   public String name;
/*    */   public int occupation;
/*    */   public int gender;
/*    */   public int level;
/*    */   public Octets invite_code;
/*    */   
/*    */   public CreateRoleArg()
/*    */   {
/* 18 */     this.name = "";
/* 19 */     this.level = 1;
/* 20 */     this.invite_code = new Octets();
/*    */   }
/*    */   
/*    */   public CreateRoleArg(String _name_, int _occupation_, int _gender_, int _level_, Octets _invite_code_) {
/* 24 */     this.name = _name_;
/* 25 */     this.occupation = _occupation_;
/* 26 */     this.gender = _gender_;
/* 27 */     this.level = _level_;
/* 28 */     this.invite_code = _invite_code_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 32 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 36 */     _os_.marshal(this.name, "UTF-16LE");
/* 37 */     _os_.marshal(this.occupation);
/* 38 */     _os_.marshal(this.gender);
/* 39 */     _os_.marshal(this.level);
/* 40 */     _os_.marshal(this.invite_code);
/* 41 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 45 */     this.name = _os_.unmarshal_String("UTF-16LE");
/* 46 */     this.occupation = _os_.unmarshal_int();
/* 47 */     this.gender = _os_.unmarshal_int();
/* 48 */     this.level = _os_.unmarshal_int();
/* 49 */     this.invite_code = _os_.unmarshal_Octets();
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 54 */     if (_o1_ == this) return true;
/* 55 */     if ((_o1_ instanceof CreateRoleArg)) {
/* 56 */       CreateRoleArg _o_ = (CreateRoleArg)_o1_;
/* 57 */       if (!this.name.equals(_o_.name)) return false;
/* 58 */       if (this.occupation != _o_.occupation) return false;
/* 59 */       if (this.gender != _o_.gender) return false;
/* 60 */       if (this.level != _o_.level) return false;
/* 61 */       if (!this.invite_code.equals(_o_.invite_code)) return false;
/* 62 */       return true;
/*    */     }
/* 64 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 68 */     int _h_ = 0;
/* 69 */     _h_ += this.name.hashCode();
/* 70 */     _h_ += this.occupation;
/* 71 */     _h_ += this.gender;
/* 72 */     _h_ += this.level;
/* 73 */     _h_ += this.invite_code.hashCode();
/* 74 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 78 */     StringBuilder _sb_ = new StringBuilder();
/* 79 */     _sb_.append("(");
/* 80 */     _sb_.append("T").append(this.name.length()).append(",");
/* 81 */     _sb_.append(this.occupation).append(",");
/* 82 */     _sb_.append(this.gender).append(",");
/* 83 */     _sb_.append(this.level).append(",");
/* 84 */     _sb_.append("B").append(this.invite_code.size()).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\CreateRoleArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */