/*     */ package mzm.gsp.map;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SMapTeamSyncPos
/*     */   extends __SMapTeamSyncPos__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590892;
/*     */   public long teamid;
/*     */   public ArrayList<Location> keypointpath;
/*     */   public int direction;
/*     */   public int mapid;
/*     */   public int mapinstanceid;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12590892;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SMapTeamSyncPos()
/*     */   {
/*  37 */     this.keypointpath = new ArrayList();
/*     */   }
/*     */   
/*     */   public SMapTeamSyncPos(long _teamid_, ArrayList<Location> _keypointpath_, int _direction_, int _mapid_, int _mapinstanceid_) {
/*  41 */     this.teamid = _teamid_;
/*  42 */     this.keypointpath = _keypointpath_;
/*  43 */     this.direction = _direction_;
/*  44 */     this.mapid = _mapid_;
/*  45 */     this.mapinstanceid = _mapinstanceid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     for (Location _v_ : this.keypointpath)
/*  50 */       if (!_v_._validator_()) return false;
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.teamid);
/*  56 */     _os_.compact_uint32(this.keypointpath.size());
/*  57 */     for (Location _v_ : this.keypointpath) {
/*  58 */       _os_.marshal(_v_);
/*     */     }
/*  60 */     _os_.marshal(this.direction);
/*  61 */     _os_.marshal(this.mapid);
/*  62 */     _os_.marshal(this.mapinstanceid);
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  67 */     this.teamid = _os_.unmarshal_long();
/*  68 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  69 */       Location _v_ = new Location();
/*  70 */       _v_.unmarshal(_os_);
/*  71 */       this.keypointpath.add(_v_);
/*     */     }
/*  73 */     this.direction = _os_.unmarshal_int();
/*  74 */     this.mapid = _os_.unmarshal_int();
/*  75 */     this.mapinstanceid = _os_.unmarshal_int();
/*  76 */     if (!_validator_()) {
/*  77 */       throw new VerifyError("validator failed");
/*     */     }
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  83 */     if (_o1_ == this) return true;
/*  84 */     if ((_o1_ instanceof SMapTeamSyncPos)) {
/*  85 */       SMapTeamSyncPos _o_ = (SMapTeamSyncPos)_o1_;
/*  86 */       if (this.teamid != _o_.teamid) return false;
/*  87 */       if (!this.keypointpath.equals(_o_.keypointpath)) return false;
/*  88 */       if (this.direction != _o_.direction) return false;
/*  89 */       if (this.mapid != _o_.mapid) return false;
/*  90 */       if (this.mapinstanceid != _o_.mapinstanceid) return false;
/*  91 */       return true;
/*     */     }
/*  93 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  97 */     int _h_ = 0;
/*  98 */     _h_ += (int)this.teamid;
/*  99 */     _h_ += this.keypointpath.hashCode();
/* 100 */     _h_ += this.direction;
/* 101 */     _h_ += this.mapid;
/* 102 */     _h_ += this.mapinstanceid;
/* 103 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 107 */     StringBuilder _sb_ = new StringBuilder();
/* 108 */     _sb_.append("(");
/* 109 */     _sb_.append(this.teamid).append(",");
/* 110 */     _sb_.append(this.keypointpath).append(",");
/* 111 */     _sb_.append(this.direction).append(",");
/* 112 */     _sb_.append(this.mapid).append(",");
/* 113 */     _sb_.append(this.mapinstanceid).append(",");
/* 114 */     _sb_.append(")");
/* 115 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\SMapTeamSyncPos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */