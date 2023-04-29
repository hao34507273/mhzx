/*     */ package mzm.gsp.map;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.LinkedList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SMapTeamInfo
/*     */   extends __SMapTeamInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590885;
/*     */   public long teamid;
/*     */   public long teamleader;
/*     */   public LinkedList<Long> followerids;
/*     */   public int memnum;
/*     */   public int multimountsid;
/*     */   public LinkedList<Long> multimountsrolelist;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12590885;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SMapTeamInfo()
/*     */   {
/*  38 */     this.followerids = new LinkedList();
/*  39 */     this.multimountsrolelist = new LinkedList();
/*     */   }
/*     */   
/*     */   public SMapTeamInfo(long _teamid_, long _teamleader_, LinkedList<Long> _followerids_, int _memnum_, int _multimountsid_, LinkedList<Long> _multimountsrolelist_) {
/*  43 */     this.teamid = _teamid_;
/*  44 */     this.teamleader = _teamleader_;
/*  45 */     this.followerids = _followerids_;
/*  46 */     this.memnum = _memnum_;
/*  47 */     this.multimountsid = _multimountsid_;
/*  48 */     this.multimountsrolelist = _multimountsrolelist_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.teamid);
/*  57 */     _os_.marshal(this.teamleader);
/*  58 */     _os_.compact_uint32(this.followerids.size());
/*  59 */     for (Long _v_ : this.followerids) {
/*  60 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  62 */     _os_.marshal(this.memnum);
/*  63 */     _os_.marshal(this.multimountsid);
/*  64 */     _os_.compact_uint32(this.multimountsrolelist.size());
/*  65 */     for (Long _v_ : this.multimountsrolelist) {
/*  66 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  72 */     this.teamid = _os_.unmarshal_long();
/*  73 */     this.teamleader = _os_.unmarshal_long();
/*  74 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  76 */       long _v_ = _os_.unmarshal_long();
/*  77 */       this.followerids.add(Long.valueOf(_v_));
/*     */     }
/*  79 */     this.memnum = _os_.unmarshal_int();
/*  80 */     this.multimountsid = _os_.unmarshal_int();
/*  81 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  83 */       long _v_ = _os_.unmarshal_long();
/*  84 */       this.multimountsrolelist.add(Long.valueOf(_v_));
/*     */     }
/*  86 */     if (!_validator_()) {
/*  87 */       throw new VerifyError("validator failed");
/*     */     }
/*  89 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  93 */     if (_o1_ == this) return true;
/*  94 */     if ((_o1_ instanceof SMapTeamInfo)) {
/*  95 */       SMapTeamInfo _o_ = (SMapTeamInfo)_o1_;
/*  96 */       if (this.teamid != _o_.teamid) return false;
/*  97 */       if (this.teamleader != _o_.teamleader) return false;
/*  98 */       if (!this.followerids.equals(_o_.followerids)) return false;
/*  99 */       if (this.memnum != _o_.memnum) return false;
/* 100 */       if (this.multimountsid != _o_.multimountsid) return false;
/* 101 */       if (!this.multimountsrolelist.equals(_o_.multimountsrolelist)) return false;
/* 102 */       return true;
/*     */     }
/* 104 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 108 */     int _h_ = 0;
/* 109 */     _h_ += (int)this.teamid;
/* 110 */     _h_ += (int)this.teamleader;
/* 111 */     _h_ += this.followerids.hashCode();
/* 112 */     _h_ += this.memnum;
/* 113 */     _h_ += this.multimountsid;
/* 114 */     _h_ += this.multimountsrolelist.hashCode();
/* 115 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 119 */     StringBuilder _sb_ = new StringBuilder();
/* 120 */     _sb_.append("(");
/* 121 */     _sb_.append(this.teamid).append(",");
/* 122 */     _sb_.append(this.teamleader).append(",");
/* 123 */     _sb_.append(this.followerids).append(",");
/* 124 */     _sb_.append(this.memnum).append(",");
/* 125 */     _sb_.append(this.multimountsid).append(",");
/* 126 */     _sb_.append(this.multimountsrolelist).append(",");
/* 127 */     _sb_.append(")");
/* 128 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\SMapTeamInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */