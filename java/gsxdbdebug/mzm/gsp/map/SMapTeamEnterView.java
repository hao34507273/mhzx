/*     */ package mzm.gsp.map;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.LinkedList;
/*     */ 
/*     */ 
/*     */ public class SMapTeamEnterView
/*     */   extends __SMapTeamEnterView__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590876;
/*     */   public long teamid;
/*     */   public TeamMember leaderinfo;
/*     */   public LinkedList<TeamMember> memberinfo;
/*     */   public ArrayList<Location> keypointpath;
/*     */   public Location curpos;
/*     */   public int direction;
/*     */   public int memnum;
/*     */   public int multimountsid;
/*     */   public LinkedList<Long> multimountsrolelist;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12590876;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SMapTeamEnterView()
/*     */   {
/*  41 */     this.leaderinfo = new TeamMember();
/*  42 */     this.memberinfo = new LinkedList();
/*  43 */     this.keypointpath = new ArrayList();
/*  44 */     this.curpos = new Location();
/*  45 */     this.multimountsrolelist = new LinkedList();
/*     */   }
/*     */   
/*     */   public SMapTeamEnterView(long _teamid_, TeamMember _leaderinfo_, LinkedList<TeamMember> _memberinfo_, ArrayList<Location> _keypointpath_, Location _curpos_, int _direction_, int _memnum_, int _multimountsid_, LinkedList<Long> _multimountsrolelist_) {
/*  49 */     this.teamid = _teamid_;
/*  50 */     this.leaderinfo = _leaderinfo_;
/*  51 */     this.memberinfo = _memberinfo_;
/*  52 */     this.keypointpath = _keypointpath_;
/*  53 */     this.curpos = _curpos_;
/*  54 */     this.direction = _direction_;
/*  55 */     this.memnum = _memnum_;
/*  56 */     this.multimountsid = _multimountsid_;
/*  57 */     this.multimountsrolelist = _multimountsrolelist_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  61 */     if (!this.leaderinfo._validator_()) return false;
/*  62 */     for (TeamMember _v_ : this.memberinfo)
/*  63 */       if (!_v_._validator_()) return false;
/*  64 */     for (Location _v_ : this.keypointpath)
/*  65 */       if (!_v_._validator_()) return false;
/*  66 */     if (!this.curpos._validator_()) return false;
/*  67 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  71 */     _os_.marshal(this.teamid);
/*  72 */     _os_.marshal(this.leaderinfo);
/*  73 */     _os_.compact_uint32(this.memberinfo.size());
/*  74 */     for (TeamMember _v_ : this.memberinfo) {
/*  75 */       _os_.marshal(_v_);
/*     */     }
/*  77 */     _os_.compact_uint32(this.keypointpath.size());
/*  78 */     for (Location _v_ : this.keypointpath) {
/*  79 */       _os_.marshal(_v_);
/*     */     }
/*  81 */     _os_.marshal(this.curpos);
/*  82 */     _os_.marshal(this.direction);
/*  83 */     _os_.marshal(this.memnum);
/*  84 */     _os_.marshal(this.multimountsid);
/*  85 */     _os_.compact_uint32(this.multimountsrolelist.size());
/*  86 */     for (Long _v_ : this.multimountsrolelist) {
/*  87 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  89 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  93 */     this.teamid = _os_.unmarshal_long();
/*  94 */     this.leaderinfo.unmarshal(_os_);
/*  95 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  96 */       TeamMember _v_ = new TeamMember();
/*  97 */       _v_.unmarshal(_os_);
/*  98 */       this.memberinfo.add(_v_);
/*     */     }
/* 100 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 101 */       Location _v_ = new Location();
/* 102 */       _v_.unmarshal(_os_);
/* 103 */       this.keypointpath.add(_v_);
/*     */     }
/* 105 */     this.curpos.unmarshal(_os_);
/* 106 */     this.direction = _os_.unmarshal_int();
/* 107 */     this.memnum = _os_.unmarshal_int();
/* 108 */     this.multimountsid = _os_.unmarshal_int();
/* 109 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/* 111 */       long _v_ = _os_.unmarshal_long();
/* 112 */       this.multimountsrolelist.add(Long.valueOf(_v_));
/*     */     }
/* 114 */     if (!_validator_()) {
/* 115 */       throw new VerifyError("validator failed");
/*     */     }
/* 117 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 121 */     if (_o1_ == this) return true;
/* 122 */     if ((_o1_ instanceof SMapTeamEnterView)) {
/* 123 */       SMapTeamEnterView _o_ = (SMapTeamEnterView)_o1_;
/* 124 */       if (this.teamid != _o_.teamid) return false;
/* 125 */       if (!this.leaderinfo.equals(_o_.leaderinfo)) return false;
/* 126 */       if (!this.memberinfo.equals(_o_.memberinfo)) return false;
/* 127 */       if (!this.keypointpath.equals(_o_.keypointpath)) return false;
/* 128 */       if (!this.curpos.equals(_o_.curpos)) return false;
/* 129 */       if (this.direction != _o_.direction) return false;
/* 130 */       if (this.memnum != _o_.memnum) return false;
/* 131 */       if (this.multimountsid != _o_.multimountsid) return false;
/* 132 */       if (!this.multimountsrolelist.equals(_o_.multimountsrolelist)) return false;
/* 133 */       return true;
/*     */     }
/* 135 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 139 */     int _h_ = 0;
/* 140 */     _h_ += (int)this.teamid;
/* 141 */     _h_ += this.leaderinfo.hashCode();
/* 142 */     _h_ += this.memberinfo.hashCode();
/* 143 */     _h_ += this.keypointpath.hashCode();
/* 144 */     _h_ += this.curpos.hashCode();
/* 145 */     _h_ += this.direction;
/* 146 */     _h_ += this.memnum;
/* 147 */     _h_ += this.multimountsid;
/* 148 */     _h_ += this.multimountsrolelist.hashCode();
/* 149 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 153 */     StringBuilder _sb_ = new StringBuilder();
/* 154 */     _sb_.append("(");
/* 155 */     _sb_.append(this.teamid).append(",");
/* 156 */     _sb_.append(this.leaderinfo).append(",");
/* 157 */     _sb_.append(this.memberinfo).append(",");
/* 158 */     _sb_.append(this.keypointpath).append(",");
/* 159 */     _sb_.append(this.curpos).append(",");
/* 160 */     _sb_.append(this.direction).append(",");
/* 161 */     _sb_.append(this.memnum).append(",");
/* 162 */     _sb_.append(this.multimountsid).append(",");
/* 163 */     _sb_.append(this.multimountsrolelist).append(",");
/* 164 */     _sb_.append(")");
/* 165 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\SMapTeamEnterView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */