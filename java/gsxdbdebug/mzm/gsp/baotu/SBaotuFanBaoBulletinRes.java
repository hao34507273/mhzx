/*    */ package mzm.gsp.baotu;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SBaotuFanBaoBulletinRes
/*    */   extends __SBaotuFanBaoBulletinRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12583687;
/*    */   public Octets rolename;
/*    */   public int itemid;
/*    */   public int mapid;
/*    */   public int controllerid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12583687;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SBaotuFanBaoBulletinRes()
/*    */   {
/* 34 */     this.rolename = new Octets();
/*    */   }
/*    */   
/*    */   public SBaotuFanBaoBulletinRes(Octets _rolename_, int _itemid_, int _mapid_, int _controllerid_) {
/* 38 */     this.rolename = _rolename_;
/* 39 */     this.itemid = _itemid_;
/* 40 */     this.mapid = _mapid_;
/* 41 */     this.controllerid = _controllerid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.rolename);
/* 50 */     _os_.marshal(this.itemid);
/* 51 */     _os_.marshal(this.mapid);
/* 52 */     _os_.marshal(this.controllerid);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.rolename = _os_.unmarshal_Octets();
/* 58 */     this.itemid = _os_.unmarshal_int();
/* 59 */     this.mapid = _os_.unmarshal_int();
/* 60 */     this.controllerid = _os_.unmarshal_int();
/* 61 */     if (!_validator_()) {
/* 62 */       throw new VerifyError("validator failed");
/*    */     }
/* 64 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 68 */     if (_o1_ == this) return true;
/* 69 */     if ((_o1_ instanceof SBaotuFanBaoBulletinRes)) {
/* 70 */       SBaotuFanBaoBulletinRes _o_ = (SBaotuFanBaoBulletinRes)_o1_;
/* 71 */       if (!this.rolename.equals(_o_.rolename)) return false;
/* 72 */       if (this.itemid != _o_.itemid) return false;
/* 73 */       if (this.mapid != _o_.mapid) return false;
/* 74 */       if (this.controllerid != _o_.controllerid) return false;
/* 75 */       return true;
/*    */     }
/* 77 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 81 */     int _h_ = 0;
/* 82 */     _h_ += this.rolename.hashCode();
/* 83 */     _h_ += this.itemid;
/* 84 */     _h_ += this.mapid;
/* 85 */     _h_ += this.controllerid;
/* 86 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 90 */     StringBuilder _sb_ = new StringBuilder();
/* 91 */     _sb_.append("(");
/* 92 */     _sb_.append("B").append(this.rolename.size()).append(",");
/* 93 */     _sb_.append(this.itemid).append(",");
/* 94 */     _sb_.append(this.mapid).append(",");
/* 95 */     _sb_.append(this.controllerid).append(",");
/* 96 */     _sb_.append(")");
/* 97 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baotu\SBaotuFanBaoBulletinRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */