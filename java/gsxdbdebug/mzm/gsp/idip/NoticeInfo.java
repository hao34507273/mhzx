/*     */ package mzm.gsp.idip;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ public class NoticeInfo implements Marshal
/*     */ {
/*     */   public long noticeid;
/*     */   public int noticetype;
/*     */   public int displaytype;
/*     */   public int hreftype;
/*     */   public Octets hreftext;
/*     */   public Octets hrefurl;
/*     */   public int sendtype;
/*     */   public Octets noticetitle;
/*     */   public Octets pictureurl;
/*     */   public long starttime;
/*     */   public long endtime;
/*     */   public int minopenserverdays;
/*     */   public int maxopenserverdays;
/*     */   public int mincreatroledays;
/*     */   public int maxcreatroledays;
/*     */   public int minrolelevel;
/*     */   public int maxrolelevel;
/*     */   public long minsaveamt;
/*     */   public long maxsaveamt;
/*     */   public int noticetag;
/*     */   public int badge;
/*     */   public int noticesortid;
/*     */   
/*     */   public NoticeInfo()
/*     */   {
/*  35 */     this.hreftext = new Octets();
/*  36 */     this.hrefurl = new Octets();
/*  37 */     this.noticetitle = new Octets();
/*  38 */     this.pictureurl = new Octets();
/*     */   }
/*     */   
/*     */   public NoticeInfo(long _noticeid_, int _noticetype_, int _displaytype_, int _hreftype_, Octets _hreftext_, Octets _hrefurl_, int _sendtype_, Octets _noticetitle_, Octets _pictureurl_, long _starttime_, long _endtime_, int _minopenserverdays_, int _maxopenserverdays_, int _mincreatroledays_, int _maxcreatroledays_, int _minrolelevel_, int _maxrolelevel_, long _minsaveamt_, long _maxsaveamt_, int _noticetag_, int _badge_, int _noticesortid_) {
/*  42 */     this.noticeid = _noticeid_;
/*  43 */     this.noticetype = _noticetype_;
/*  44 */     this.displaytype = _displaytype_;
/*  45 */     this.hreftype = _hreftype_;
/*  46 */     this.hreftext = _hreftext_;
/*  47 */     this.hrefurl = _hrefurl_;
/*  48 */     this.sendtype = _sendtype_;
/*  49 */     this.noticetitle = _noticetitle_;
/*  50 */     this.pictureurl = _pictureurl_;
/*  51 */     this.starttime = _starttime_;
/*  52 */     this.endtime = _endtime_;
/*  53 */     this.minopenserverdays = _minopenserverdays_;
/*  54 */     this.maxopenserverdays = _maxopenserverdays_;
/*  55 */     this.mincreatroledays = _mincreatroledays_;
/*  56 */     this.maxcreatroledays = _maxcreatroledays_;
/*  57 */     this.minrolelevel = _minrolelevel_;
/*  58 */     this.maxrolelevel = _maxrolelevel_;
/*  59 */     this.minsaveamt = _minsaveamt_;
/*  60 */     this.maxsaveamt = _maxsaveamt_;
/*  61 */     this.noticetag = _noticetag_;
/*  62 */     this.badge = _badge_;
/*  63 */     this.noticesortid = _noticesortid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  67 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  71 */     _os_.marshal(this.noticeid);
/*  72 */     _os_.marshal(this.noticetype);
/*  73 */     _os_.marshal(this.displaytype);
/*  74 */     _os_.marshal(this.hreftype);
/*  75 */     _os_.marshal(this.hreftext);
/*  76 */     _os_.marshal(this.hrefurl);
/*  77 */     _os_.marshal(this.sendtype);
/*  78 */     _os_.marshal(this.noticetitle);
/*  79 */     _os_.marshal(this.pictureurl);
/*  80 */     _os_.marshal(this.starttime);
/*  81 */     _os_.marshal(this.endtime);
/*  82 */     _os_.marshal(this.minopenserverdays);
/*  83 */     _os_.marshal(this.maxopenserverdays);
/*  84 */     _os_.marshal(this.mincreatroledays);
/*  85 */     _os_.marshal(this.maxcreatroledays);
/*  86 */     _os_.marshal(this.minrolelevel);
/*  87 */     _os_.marshal(this.maxrolelevel);
/*  88 */     _os_.marshal(this.minsaveamt);
/*  89 */     _os_.marshal(this.maxsaveamt);
/*  90 */     _os_.marshal(this.noticetag);
/*  91 */     _os_.marshal(this.badge);
/*  92 */     _os_.marshal(this.noticesortid);
/*  93 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  97 */     this.noticeid = _os_.unmarshal_long();
/*  98 */     this.noticetype = _os_.unmarshal_int();
/*  99 */     this.displaytype = _os_.unmarshal_int();
/* 100 */     this.hreftype = _os_.unmarshal_int();
/* 101 */     this.hreftext = _os_.unmarshal_Octets();
/* 102 */     this.hrefurl = _os_.unmarshal_Octets();
/* 103 */     this.sendtype = _os_.unmarshal_int();
/* 104 */     this.noticetitle = _os_.unmarshal_Octets();
/* 105 */     this.pictureurl = _os_.unmarshal_Octets();
/* 106 */     this.starttime = _os_.unmarshal_long();
/* 107 */     this.endtime = _os_.unmarshal_long();
/* 108 */     this.minopenserverdays = _os_.unmarshal_int();
/* 109 */     this.maxopenserverdays = _os_.unmarshal_int();
/* 110 */     this.mincreatroledays = _os_.unmarshal_int();
/* 111 */     this.maxcreatroledays = _os_.unmarshal_int();
/* 112 */     this.minrolelevel = _os_.unmarshal_int();
/* 113 */     this.maxrolelevel = _os_.unmarshal_int();
/* 114 */     this.minsaveamt = _os_.unmarshal_long();
/* 115 */     this.maxsaveamt = _os_.unmarshal_long();
/* 116 */     this.noticetag = _os_.unmarshal_int();
/* 117 */     this.badge = _os_.unmarshal_int();
/* 118 */     this.noticesortid = _os_.unmarshal_int();
/* 119 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 123 */     if (_o1_ == this) return true;
/* 124 */     if ((_o1_ instanceof NoticeInfo)) {
/* 125 */       NoticeInfo _o_ = (NoticeInfo)_o1_;
/* 126 */       if (this.noticeid != _o_.noticeid) return false;
/* 127 */       if (this.noticetype != _o_.noticetype) return false;
/* 128 */       if (this.displaytype != _o_.displaytype) return false;
/* 129 */       if (this.hreftype != _o_.hreftype) return false;
/* 130 */       if (!this.hreftext.equals(_o_.hreftext)) return false;
/* 131 */       if (!this.hrefurl.equals(_o_.hrefurl)) return false;
/* 132 */       if (this.sendtype != _o_.sendtype) return false;
/* 133 */       if (!this.noticetitle.equals(_o_.noticetitle)) return false;
/* 134 */       if (!this.pictureurl.equals(_o_.pictureurl)) return false;
/* 135 */       if (this.starttime != _o_.starttime) return false;
/* 136 */       if (this.endtime != _o_.endtime) return false;
/* 137 */       if (this.minopenserverdays != _o_.minopenserverdays) return false;
/* 138 */       if (this.maxopenserverdays != _o_.maxopenserverdays) return false;
/* 139 */       if (this.mincreatroledays != _o_.mincreatroledays) return false;
/* 140 */       if (this.maxcreatroledays != _o_.maxcreatroledays) return false;
/* 141 */       if (this.minrolelevel != _o_.minrolelevel) return false;
/* 142 */       if (this.maxrolelevel != _o_.maxrolelevel) return false;
/* 143 */       if (this.minsaveamt != _o_.minsaveamt) return false;
/* 144 */       if (this.maxsaveamt != _o_.maxsaveamt) return false;
/* 145 */       if (this.noticetag != _o_.noticetag) return false;
/* 146 */       if (this.badge != _o_.badge) return false;
/* 147 */       if (this.noticesortid != _o_.noticesortid) return false;
/* 148 */       return true;
/*     */     }
/* 150 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 154 */     int _h_ = 0;
/* 155 */     _h_ += (int)this.noticeid;
/* 156 */     _h_ += this.noticetype;
/* 157 */     _h_ += this.displaytype;
/* 158 */     _h_ += this.hreftype;
/* 159 */     _h_ += this.hreftext.hashCode();
/* 160 */     _h_ += this.hrefurl.hashCode();
/* 161 */     _h_ += this.sendtype;
/* 162 */     _h_ += this.noticetitle.hashCode();
/* 163 */     _h_ += this.pictureurl.hashCode();
/* 164 */     _h_ += (int)this.starttime;
/* 165 */     _h_ += (int)this.endtime;
/* 166 */     _h_ += this.minopenserverdays;
/* 167 */     _h_ += this.maxopenserverdays;
/* 168 */     _h_ += this.mincreatroledays;
/* 169 */     _h_ += this.maxcreatroledays;
/* 170 */     _h_ += this.minrolelevel;
/* 171 */     _h_ += this.maxrolelevel;
/* 172 */     _h_ += (int)this.minsaveamt;
/* 173 */     _h_ += (int)this.maxsaveamt;
/* 174 */     _h_ += this.noticetag;
/* 175 */     _h_ += this.badge;
/* 176 */     _h_ += this.noticesortid;
/* 177 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 181 */     StringBuilder _sb_ = new StringBuilder();
/* 182 */     _sb_.append("(");
/* 183 */     _sb_.append(this.noticeid).append(",");
/* 184 */     _sb_.append(this.noticetype).append(",");
/* 185 */     _sb_.append(this.displaytype).append(",");
/* 186 */     _sb_.append(this.hreftype).append(",");
/* 187 */     _sb_.append("B").append(this.hreftext.size()).append(",");
/* 188 */     _sb_.append("B").append(this.hrefurl.size()).append(",");
/* 189 */     _sb_.append(this.sendtype).append(",");
/* 190 */     _sb_.append("B").append(this.noticetitle.size()).append(",");
/* 191 */     _sb_.append("B").append(this.pictureurl.size()).append(",");
/* 192 */     _sb_.append(this.starttime).append(",");
/* 193 */     _sb_.append(this.endtime).append(",");
/* 194 */     _sb_.append(this.minopenserverdays).append(",");
/* 195 */     _sb_.append(this.maxopenserverdays).append(",");
/* 196 */     _sb_.append(this.mincreatroledays).append(",");
/* 197 */     _sb_.append(this.maxcreatroledays).append(",");
/* 198 */     _sb_.append(this.minrolelevel).append(",");
/* 199 */     _sb_.append(this.maxrolelevel).append(",");
/* 200 */     _sb_.append(this.minsaveamt).append(",");
/* 201 */     _sb_.append(this.maxsaveamt).append(",");
/* 202 */     _sb_.append(this.noticetag).append(",");
/* 203 */     _sb_.append(this.badge).append(",");
/* 204 */     _sb_.append(this.noticesortid).append(",");
/* 205 */     _sb_.append(")");
/* 206 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\NoticeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */