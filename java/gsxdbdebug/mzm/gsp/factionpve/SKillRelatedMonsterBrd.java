/*    */ package mzm.gsp.factionpve;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
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
/*    */ public class SKillRelatedMonsterBrd
/*    */   extends __SKillRelatedMonsterBrd__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12613649;
/*    */   public String leader_name;
/*    */   public int related_monster;
/*    */   public int bossid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12613649;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SKillRelatedMonsterBrd()
/*    */   {
/* 35 */     this.leader_name = "";
/*    */   }
/*    */   
/*    */   public SKillRelatedMonsterBrd(String _leader_name_, int _related_monster_, int _bossid_) {
/* 39 */     this.leader_name = _leader_name_;
/* 40 */     this.related_monster = _related_monster_;
/* 41 */     this.bossid = _bossid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.leader_name, "UTF-16LE");
/* 50 */     _os_.marshal(this.related_monster);
/* 51 */     _os_.marshal(this.bossid);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.leader_name = _os_.unmarshal_String("UTF-16LE");
/* 57 */     this.related_monster = _os_.unmarshal_int();
/* 58 */     this.bossid = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof SKillRelatedMonsterBrd)) {
/* 68 */       SKillRelatedMonsterBrd _o_ = (SKillRelatedMonsterBrd)_o1_;
/* 69 */       if (!this.leader_name.equals(_o_.leader_name)) return false;
/* 70 */       if (this.related_monster != _o_.related_monster) return false;
/* 71 */       if (this.bossid != _o_.bossid) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += this.leader_name.hashCode();
/* 80 */     _h_ += this.related_monster;
/* 81 */     _h_ += this.bossid;
/* 82 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 86 */     StringBuilder _sb_ = new StringBuilder();
/* 87 */     _sb_.append("(");
/* 88 */     _sb_.append("T").append(this.leader_name.length()).append(",");
/* 89 */     _sb_.append(this.related_monster).append(",");
/* 90 */     _sb_.append(this.bossid).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factionpve\SKillRelatedMonsterBrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */