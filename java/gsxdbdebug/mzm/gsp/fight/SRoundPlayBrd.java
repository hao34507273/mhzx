/*    */ package mzm.gsp.fight;
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
/*    */ public class SRoundPlayBrd
/*    */   extends __SRoundPlayBrd__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12594185;
/*    */   public long fight_uuid;
/*    */   public ArrayList<Play> playlist;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12594185;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SRoundPlayBrd()
/*    */   {
/* 34 */     this.playlist = new ArrayList();
/*    */   }
/*    */   
/*    */   public SRoundPlayBrd(long _fight_uuid_, ArrayList<Play> _playlist_) {
/* 38 */     this.fight_uuid = _fight_uuid_;
/* 39 */     this.playlist = _playlist_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     for (Play _v_ : this.playlist)
/* 44 */       if (!_v_._validator_()) return false;
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.fight_uuid);
/* 50 */     _os_.compact_uint32(this.playlist.size());
/* 51 */     for (Play _v_ : this.playlist) {
/* 52 */       _os_.marshal(_v_);
/*    */     }
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     this.fight_uuid = _os_.unmarshal_long();
/* 59 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 60 */       Play _v_ = new Play();
/* 61 */       _v_.unmarshal(_os_);
/* 62 */       this.playlist.add(_v_);
/*    */     }
/* 64 */     if (!_validator_()) {
/* 65 */       throw new VerifyError("validator failed");
/*    */     }
/* 67 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 71 */     if (_o1_ == this) return true;
/* 72 */     if ((_o1_ instanceof SRoundPlayBrd)) {
/* 73 */       SRoundPlayBrd _o_ = (SRoundPlayBrd)_o1_;
/* 74 */       if (this.fight_uuid != _o_.fight_uuid) return false;
/* 75 */       if (!this.playlist.equals(_o_.playlist)) return false;
/* 76 */       return true;
/*    */     }
/* 78 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 82 */     int _h_ = 0;
/* 83 */     _h_ += (int)this.fight_uuid;
/* 84 */     _h_ += this.playlist.hashCode();
/* 85 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 89 */     StringBuilder _sb_ = new StringBuilder();
/* 90 */     _sb_.append("(");
/* 91 */     _sb_.append(this.fight_uuid).append(",");
/* 92 */     _sb_.append(this.playlist).append(",");
/* 93 */     _sb_.append(")");
/* 94 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\SRoundPlayBrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */