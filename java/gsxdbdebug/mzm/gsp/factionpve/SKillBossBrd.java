/*    */ package mzm.gsp.factionpve;
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
/*    */ public class SKillBossBrd
/*    */   extends __SKillBossBrd__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12613651;
/*    */   public ArrayList<String> roles;
/*    */   public int bossid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12613651;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SKillBossBrd()
/*    */   {
/* 34 */     this.roles = new ArrayList();
/*    */   }
/*    */   
/*    */   public SKillBossBrd(ArrayList<String> _roles_, int _bossid_) {
/* 38 */     this.roles = _roles_;
/* 39 */     this.bossid = _bossid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.compact_uint32(this.roles.size());
/* 48 */     for (String _v_ : this.roles) {
/* 49 */       _os_.marshal(_v_, "UTF-16LE");
/*    */     }
/* 51 */     _os_.marshal(this.bossid);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 58 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/* 59 */       this.roles.add(_v_);
/*    */     }
/* 61 */     this.bossid = _os_.unmarshal_int();
/* 62 */     if (!_validator_()) {
/* 63 */       throw new VerifyError("validator failed");
/*    */     }
/* 65 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 69 */     if (_o1_ == this) return true;
/* 70 */     if ((_o1_ instanceof SKillBossBrd)) {
/* 71 */       SKillBossBrd _o_ = (SKillBossBrd)_o1_;
/* 72 */       if (!this.roles.equals(_o_.roles)) return false;
/* 73 */       if (this.bossid != _o_.bossid) return false;
/* 74 */       return true;
/*    */     }
/* 76 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 80 */     int _h_ = 0;
/* 81 */     _h_ += this.roles.hashCode();
/* 82 */     _h_ += this.bossid;
/* 83 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 87 */     StringBuilder _sb_ = new StringBuilder();
/* 88 */     _sb_.append("(");
/* 89 */     _sb_.append(this.roles).append(",");
/* 90 */     _sb_.append(this.bossid).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factionpve\SKillBossBrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */