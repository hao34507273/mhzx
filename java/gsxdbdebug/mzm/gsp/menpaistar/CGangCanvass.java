/*    */ package mzm.gsp.menpaistar;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.menpaistar.main.PCGangCanvass;
/*    */ 
/*    */ 
/*    */ public class CGangCanvass
/*    */   extends __CGangCanvass__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12612363;
/*    */   public long target_roleid;
/*    */   public Octets text;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 1L)
/*    */     {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleId, new PCGangCanvass(roleId, this.target_roleid, this.text));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12612363;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CGangCanvass()
/*    */   {
/* 39 */     this.text = new Octets();
/*    */   }
/*    */   
/*    */   public CGangCanvass(long _target_roleid_, Octets _text_) {
/* 43 */     this.target_roleid = _target_roleid_;
/* 44 */     this.text = _text_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 48 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 52 */     _os_.marshal(this.target_roleid);
/* 53 */     _os_.marshal(this.text);
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     this.target_roleid = _os_.unmarshal_long();
/* 59 */     this.text = _os_.unmarshal_Octets();
/* 60 */     if (!_validator_()) {
/* 61 */       throw new VerifyError("validator failed");
/*    */     }
/* 63 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 67 */     if (_o1_ == this) return true;
/* 68 */     if ((_o1_ instanceof CGangCanvass)) {
/* 69 */       CGangCanvass _o_ = (CGangCanvass)_o1_;
/* 70 */       if (this.target_roleid != _o_.target_roleid) return false;
/* 71 */       if (!this.text.equals(_o_.text)) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += (int)this.target_roleid;
/* 80 */     _h_ += this.text.hashCode();
/* 81 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 85 */     StringBuilder _sb_ = new StringBuilder();
/* 86 */     _sb_.append("(");
/* 87 */     _sb_.append(this.target_roleid).append(",");
/* 88 */     _sb_.append("B").append(this.text.size()).append(",");
/* 89 */     _sb_.append(")");
/* 90 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\CGangCanvass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */