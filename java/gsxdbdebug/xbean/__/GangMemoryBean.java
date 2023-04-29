/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class GangMemoryBean extends XBean implements xbean.GangMemoryBean
/*     */ {
/*     */   private ArrayList<xbean.GangApply> applylist;
/*     */   private long gangworldid;
/*     */   private HashMap<Long, xbean.GangTeamApplicants> teamapplicants;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.applylist.clear();
/*  23 */     this.gangworldid = 0L;
/*  24 */     this.teamapplicants.clear();
/*     */   }
/*     */   
/*     */   GangMemoryBean(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.applylist = new ArrayList();
/*  31 */     this.teamapplicants = new HashMap();
/*     */   }
/*     */   
/*     */   public GangMemoryBean()
/*     */   {
/*  36 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public GangMemoryBean(GangMemoryBean _o_)
/*     */   {
/*  41 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   GangMemoryBean(xbean.GangMemoryBean _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  46 */     super(_xp_, _vn_);
/*  47 */     if ((_o1_ instanceof GangMemoryBean)) { assign((GangMemoryBean)_o1_);
/*  48 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  49 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  50 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(GangMemoryBean _o_) {
/*  55 */     _o_._xdb_verify_unsafe_();
/*  56 */     this.applylist = new ArrayList();
/*  57 */     for (xbean.GangApply _v_ : _o_.applylist)
/*  58 */       this.applylist.add(new GangApply(_v_, this, "applylist"));
/*  59 */     this.gangworldid = _o_.gangworldid;
/*  60 */     this.teamapplicants = new HashMap();
/*  61 */     for (Map.Entry<Long, xbean.GangTeamApplicants> _e_ : _o_.teamapplicants.entrySet()) {
/*  62 */       this.teamapplicants.put(_e_.getKey(), new GangTeamApplicants((xbean.GangTeamApplicants)_e_.getValue(), this, "teamapplicants"));
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  67 */     this.applylist = new ArrayList();
/*  68 */     for (xbean.GangApply _v_ : _o_.applylist)
/*  69 */       this.applylist.add(new GangApply(_v_, this, "applylist"));
/*  70 */     this.gangworldid = _o_.gangworldid;
/*  71 */     this.teamapplicants = new HashMap();
/*  72 */     for (Map.Entry<Long, xbean.GangTeamApplicants> _e_ : _o_.teamapplicants.entrySet()) {
/*  73 */       this.teamapplicants.put(_e_.getKey(), new GangTeamApplicants((xbean.GangTeamApplicants)_e_.getValue(), this, "teamapplicants"));
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  79 */     _xdb_verify_unsafe_();
/*  80 */     _os_.compact_uint32(this.applylist.size());
/*  81 */     for (xbean.GangApply _v_ : this.applylist)
/*     */     {
/*  83 */       _v_.marshal(_os_);
/*     */     }
/*  85 */     _os_.marshal(this.gangworldid);
/*  86 */     _os_.compact_uint32(this.teamapplicants.size());
/*  87 */     for (Map.Entry<Long, xbean.GangTeamApplicants> _e_ : this.teamapplicants.entrySet())
/*     */     {
/*  89 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  90 */       ((xbean.GangTeamApplicants)_e_.getValue()).marshal(_os_);
/*     */     }
/*  92 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  98 */     _xdb_verify_unsafe_();
/*  99 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 101 */       xbean.GangApply _v_ = new GangApply(0, this, "applylist");
/* 102 */       _v_.unmarshal(_os_);
/* 103 */       this.applylist.add(_v_);
/*     */     }
/* 105 */     this.gangworldid = _os_.unmarshal_long();
/*     */     
/* 107 */     int size = _os_.uncompact_uint32();
/* 108 */     if (size >= 12)
/*     */     {
/* 110 */       this.teamapplicants = new HashMap(size * 2);
/*     */     }
/* 112 */     for (; size > 0; size--)
/*     */     {
/* 114 */       long _k_ = 0L;
/* 115 */       _k_ = _os_.unmarshal_long();
/* 116 */       xbean.GangTeamApplicants _v_ = new GangTeamApplicants(0, this, "teamapplicants");
/* 117 */       _v_.unmarshal(_os_);
/* 118 */       this.teamapplicants.put(Long.valueOf(_k_), _v_);
/*     */     }
/*     */     
/* 121 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 127 */     _xdb_verify_unsafe_();
/* 128 */     int _size_ = 0;
/* 129 */     for (xbean.GangApply _v_ : this.applylist)
/*     */     {
/* 131 */       _size_ += CodedOutputStream.computeMessageSize(1, _v_);
/*     */     }
/* 133 */     _size_ += CodedOutputStream.computeInt64Size(2, this.gangworldid);
/* 134 */     for (Map.Entry<Long, xbean.GangTeamApplicants> _e_ : this.teamapplicants.entrySet())
/*     */     {
/* 136 */       _size_ += CodedOutputStream.computeInt64Size(3, ((Long)_e_.getKey()).longValue());
/* 137 */       _size_ += CodedOutputStream.computeMessageSize(3, (ppbio.Message)_e_.getValue());
/*     */     }
/* 139 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 145 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 148 */       for (xbean.GangApply _v_ : this.applylist)
/*     */       {
/* 150 */         _output_.writeMessage(1, _v_);
/*     */       }
/* 152 */       _output_.writeInt64(2, this.gangworldid);
/* 153 */       for (Map.Entry<Long, xbean.GangTeamApplicants> _e_ : this.teamapplicants.entrySet())
/*     */       {
/* 155 */         _output_.writeInt64(3, ((Long)_e_.getKey()).longValue());
/* 156 */         _output_.writeMessage(3, (ppbio.Message)_e_.getValue());
/*     */       }
/*     */     }
/*     */     catch (java.io.IOException e)
/*     */     {
/* 161 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 163 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 169 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 172 */       boolean done = false;
/* 173 */       while (!done)
/*     */       {
/* 175 */         int tag = _input_.readTag();
/* 176 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 180 */           done = true;
/* 181 */           break;
/*     */         
/*     */ 
/*     */         case 10: 
/* 185 */           xbean.GangApply _v_ = new GangApply(0, this, "applylist");
/* 186 */           _input_.readMessage(_v_);
/* 187 */           this.applylist.add(_v_);
/* 188 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 192 */           this.gangworldid = _input_.readInt64();
/* 193 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 197 */           long _k_ = 0L;
/* 198 */           _k_ = _input_.readInt64();
/* 199 */           int readTag = _input_.readTag();
/* 200 */           if (26 != readTag)
/*     */           {
/* 202 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 204 */           xbean.GangTeamApplicants _v_ = new GangTeamApplicants(0, this, "teamapplicants");
/* 205 */           _input_.readMessage(_v_);
/* 206 */           this.teamapplicants.put(Long.valueOf(_k_), _v_);
/* 207 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 211 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 213 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 222 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (java.io.IOException e)
/*     */     {
/* 226 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 228 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GangMemoryBean copy()
/*     */   {
/* 234 */     _xdb_verify_unsafe_();
/* 235 */     return new GangMemoryBean(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GangMemoryBean toData()
/*     */   {
/* 241 */     _xdb_verify_unsafe_();
/* 242 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.GangMemoryBean toBean()
/*     */   {
/* 247 */     _xdb_verify_unsafe_();
/* 248 */     return new GangMemoryBean(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GangMemoryBean toDataIf()
/*     */   {
/* 254 */     _xdb_verify_unsafe_();
/* 255 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.GangMemoryBean toBeanIf()
/*     */   {
/* 260 */     _xdb_verify_unsafe_();
/* 261 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 267 */     _xdb_verify_unsafe_();
/* 268 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<xbean.GangApply> getApplylist()
/*     */   {
/* 275 */     _xdb_verify_unsafe_();
/* 276 */     return xdb.Logs.logList(new xdb.LogKey(this, "applylist"), this.applylist);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<xbean.GangApply> getApplylistAsData()
/*     */   {
/* 282 */     _xdb_verify_unsafe_();
/*     */     
/* 284 */     GangMemoryBean _o_ = this;
/* 285 */     List<xbean.GangApply> applylist = new ArrayList();
/* 286 */     for (xbean.GangApply _v_ : _o_.applylist)
/* 287 */       applylist.add(new GangApply.Data(_v_));
/* 288 */     return applylist;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getGangworldid()
/*     */   {
/* 295 */     _xdb_verify_unsafe_();
/* 296 */     return this.gangworldid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, xbean.GangTeamApplicants> getTeamapplicants()
/*     */   {
/* 303 */     _xdb_verify_unsafe_();
/* 304 */     return xdb.Logs.logMap(new xdb.LogKey(this, "teamapplicants"), this.teamapplicants);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, xbean.GangTeamApplicants> getTeamapplicantsAsData()
/*     */   {
/* 311 */     _xdb_verify_unsafe_();
/*     */     
/* 313 */     GangMemoryBean _o_ = this;
/* 314 */     Map<Long, xbean.GangTeamApplicants> teamapplicants = new HashMap();
/* 315 */     for (Map.Entry<Long, xbean.GangTeamApplicants> _e_ : _o_.teamapplicants.entrySet())
/* 316 */       teamapplicants.put(_e_.getKey(), new GangTeamApplicants.Data((xbean.GangTeamApplicants)_e_.getValue()));
/* 317 */     return teamapplicants;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setGangworldid(long _v_)
/*     */   {
/* 324 */     _xdb_verify_unsafe_();
/* 325 */     xdb.Logs.logIf(new xdb.LogKey(this, "gangworldid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 329 */         new xdb.logs.LogLong(this, GangMemoryBean.this.gangworldid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 333 */             GangMemoryBean.this.gangworldid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 337 */     });
/* 338 */     this.gangworldid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 344 */     _xdb_verify_unsafe_();
/* 345 */     GangMemoryBean _o_ = null;
/* 346 */     if ((_o1_ instanceof GangMemoryBean)) { _o_ = (GangMemoryBean)_o1_;
/* 347 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 348 */       return false;
/* 349 */     if (!this.applylist.equals(_o_.applylist)) return false;
/* 350 */     if (this.gangworldid != _o_.gangworldid) return false;
/* 351 */     if (!this.teamapplicants.equals(_o_.teamapplicants)) return false;
/* 352 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 358 */     _xdb_verify_unsafe_();
/* 359 */     int _h_ = 0;
/* 360 */     _h_ += this.applylist.hashCode();
/* 361 */     _h_ = (int)(_h_ + this.gangworldid);
/* 362 */     _h_ += this.teamapplicants.hashCode();
/* 363 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 369 */     _xdb_verify_unsafe_();
/* 370 */     StringBuilder _sb_ = new StringBuilder();
/* 371 */     _sb_.append("(");
/* 372 */     _sb_.append(this.applylist);
/* 373 */     _sb_.append(",");
/* 374 */     _sb_.append(this.gangworldid);
/* 375 */     _sb_.append(",");
/* 376 */     _sb_.append(this.teamapplicants);
/* 377 */     _sb_.append(")");
/* 378 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 384 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 385 */     lb.add(new xdb.logs.ListenableChanged().setVarName("applylist"));
/* 386 */     lb.add(new xdb.logs.ListenableChanged().setVarName("gangworldid"));
/* 387 */     lb.add(new xdb.logs.ListenableMap().setVarName("teamapplicants"));
/* 388 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.GangMemoryBean {
/*     */     private Const() {}
/*     */     
/*     */     GangMemoryBean nThis() {
/* 395 */       return GangMemoryBean.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 401 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GangMemoryBean copy()
/*     */     {
/* 407 */       return GangMemoryBean.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GangMemoryBean toData()
/*     */     {
/* 413 */       return GangMemoryBean.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.GangMemoryBean toBean()
/*     */     {
/* 418 */       return GangMemoryBean.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GangMemoryBean toDataIf()
/*     */     {
/* 424 */       return GangMemoryBean.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.GangMemoryBean toBeanIf()
/*     */     {
/* 429 */       return GangMemoryBean.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.GangApply> getApplylist()
/*     */     {
/* 436 */       GangMemoryBean.this._xdb_verify_unsafe_();
/* 437 */       return xdb.Consts.constList(GangMemoryBean.this.applylist);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<xbean.GangApply> getApplylistAsData()
/*     */     {
/* 443 */       GangMemoryBean.this._xdb_verify_unsafe_();
/*     */       
/* 445 */       GangMemoryBean _o_ = GangMemoryBean.this;
/* 446 */       List<xbean.GangApply> applylist = new ArrayList();
/* 447 */       for (xbean.GangApply _v_ : _o_.applylist)
/* 448 */         applylist.add(new GangApply.Data(_v_));
/* 449 */       return applylist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getGangworldid()
/*     */     {
/* 456 */       GangMemoryBean.this._xdb_verify_unsafe_();
/* 457 */       return GangMemoryBean.this.gangworldid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.GangTeamApplicants> getTeamapplicants()
/*     */     {
/* 464 */       GangMemoryBean.this._xdb_verify_unsafe_();
/* 465 */       return xdb.Consts.constMap(GangMemoryBean.this.teamapplicants);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.GangTeamApplicants> getTeamapplicantsAsData()
/*     */     {
/* 472 */       GangMemoryBean.this._xdb_verify_unsafe_();
/*     */       
/* 474 */       GangMemoryBean _o_ = GangMemoryBean.this;
/* 475 */       Map<Long, xbean.GangTeamApplicants> teamapplicants = new HashMap();
/* 476 */       for (Map.Entry<Long, xbean.GangTeamApplicants> _e_ : _o_.teamapplicants.entrySet())
/* 477 */         teamapplicants.put(_e_.getKey(), new GangTeamApplicants.Data((xbean.GangTeamApplicants)_e_.getValue()));
/* 478 */       return teamapplicants;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGangworldid(long _v_)
/*     */     {
/* 485 */       GangMemoryBean.this._xdb_verify_unsafe_();
/* 486 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 492 */       GangMemoryBean.this._xdb_verify_unsafe_();
/* 493 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 499 */       GangMemoryBean.this._xdb_verify_unsafe_();
/* 500 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 506 */       return GangMemoryBean.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 512 */       return GangMemoryBean.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 518 */       GangMemoryBean.this._xdb_verify_unsafe_();
/* 519 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 525 */       return GangMemoryBean.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 531 */       return GangMemoryBean.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 537 */       GangMemoryBean.this._xdb_verify_unsafe_();
/* 538 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 544 */       return GangMemoryBean.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 550 */       return GangMemoryBean.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 556 */       return GangMemoryBean.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 562 */       return GangMemoryBean.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 568 */       return GangMemoryBean.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 574 */       return GangMemoryBean.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 580 */       return GangMemoryBean.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.GangMemoryBean
/*     */   {
/*     */     private ArrayList<xbean.GangApply> applylist;
/*     */     
/*     */     private long gangworldid;
/*     */     
/*     */     private HashMap<Long, xbean.GangTeamApplicants> teamapplicants;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 596 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 601 */       this.applylist = new ArrayList();
/* 602 */       this.teamapplicants = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.GangMemoryBean _o1_)
/*     */     {
/* 607 */       if ((_o1_ instanceof GangMemoryBean)) { assign((GangMemoryBean)_o1_);
/* 608 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 609 */       } else if ((_o1_ instanceof GangMemoryBean.Const)) assign(((GangMemoryBean.Const)_o1_).nThis()); else {
/* 610 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(GangMemoryBean _o_) {
/* 615 */       this.applylist = new ArrayList();
/* 616 */       for (xbean.GangApply _v_ : _o_.applylist)
/* 617 */         this.applylist.add(new GangApply.Data(_v_));
/* 618 */       this.gangworldid = _o_.gangworldid;
/* 619 */       this.teamapplicants = new HashMap();
/* 620 */       for (Map.Entry<Long, xbean.GangTeamApplicants> _e_ : _o_.teamapplicants.entrySet()) {
/* 621 */         this.teamapplicants.put(_e_.getKey(), new GangTeamApplicants.Data((xbean.GangTeamApplicants)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 626 */       this.applylist = new ArrayList();
/* 627 */       for (xbean.GangApply _v_ : _o_.applylist)
/* 628 */         this.applylist.add(new GangApply.Data(_v_));
/* 629 */       this.gangworldid = _o_.gangworldid;
/* 630 */       this.teamapplicants = new HashMap();
/* 631 */       for (Map.Entry<Long, xbean.GangTeamApplicants> _e_ : _o_.teamapplicants.entrySet()) {
/* 632 */         this.teamapplicants.put(_e_.getKey(), new GangTeamApplicants.Data((xbean.GangTeamApplicants)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 638 */       _os_.compact_uint32(this.applylist.size());
/* 639 */       for (xbean.GangApply _v_ : this.applylist)
/*     */       {
/* 641 */         _v_.marshal(_os_);
/*     */       }
/* 643 */       _os_.marshal(this.gangworldid);
/* 644 */       _os_.compact_uint32(this.teamapplicants.size());
/* 645 */       for (Map.Entry<Long, xbean.GangTeamApplicants> _e_ : this.teamapplicants.entrySet())
/*     */       {
/* 647 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 648 */         ((xbean.GangTeamApplicants)_e_.getValue()).marshal(_os_);
/*     */       }
/* 650 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 656 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 658 */         xbean.GangApply _v_ = xbean.Pod.newGangApplyData();
/* 659 */         _v_.unmarshal(_os_);
/* 660 */         this.applylist.add(_v_);
/*     */       }
/* 662 */       this.gangworldid = _os_.unmarshal_long();
/*     */       
/* 664 */       int size = _os_.uncompact_uint32();
/* 665 */       if (size >= 12)
/*     */       {
/* 667 */         this.teamapplicants = new HashMap(size * 2);
/*     */       }
/* 669 */       for (; size > 0; size--)
/*     */       {
/* 671 */         long _k_ = 0L;
/* 672 */         _k_ = _os_.unmarshal_long();
/* 673 */         xbean.GangTeamApplicants _v_ = xbean.Pod.newGangTeamApplicantsData();
/* 674 */         _v_.unmarshal(_os_);
/* 675 */         this.teamapplicants.put(Long.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 678 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 684 */       int _size_ = 0;
/* 685 */       for (xbean.GangApply _v_ : this.applylist)
/*     */       {
/* 687 */         _size_ += CodedOutputStream.computeMessageSize(1, _v_);
/*     */       }
/* 689 */       _size_ += CodedOutputStream.computeInt64Size(2, this.gangworldid);
/* 690 */       for (Map.Entry<Long, xbean.GangTeamApplicants> _e_ : this.teamapplicants.entrySet())
/*     */       {
/* 692 */         _size_ += CodedOutputStream.computeInt64Size(3, ((Long)_e_.getKey()).longValue());
/* 693 */         _size_ += CodedOutputStream.computeMessageSize(3, (ppbio.Message)_e_.getValue());
/*     */       }
/* 695 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 703 */         for (xbean.GangApply _v_ : this.applylist)
/*     */         {
/* 705 */           _output_.writeMessage(1, _v_);
/*     */         }
/* 707 */         _output_.writeInt64(2, this.gangworldid);
/* 708 */         for (Map.Entry<Long, xbean.GangTeamApplicants> _e_ : this.teamapplicants.entrySet())
/*     */         {
/* 710 */           _output_.writeInt64(3, ((Long)_e_.getKey()).longValue());
/* 711 */           _output_.writeMessage(3, (ppbio.Message)_e_.getValue());
/*     */         }
/*     */       }
/*     */       catch (java.io.IOException e)
/*     */       {
/* 716 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 718 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 726 */         boolean done = false;
/* 727 */         while (!done)
/*     */         {
/* 729 */           int tag = _input_.readTag();
/* 730 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 734 */             done = true;
/* 735 */             break;
/*     */           
/*     */ 
/*     */           case 10: 
/* 739 */             xbean.GangApply _v_ = xbean.Pod.newGangApplyData();
/* 740 */             _input_.readMessage(_v_);
/* 741 */             this.applylist.add(_v_);
/* 742 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 746 */             this.gangworldid = _input_.readInt64();
/* 747 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 751 */             long _k_ = 0L;
/* 752 */             _k_ = _input_.readInt64();
/* 753 */             int readTag = _input_.readTag();
/* 754 */             if (26 != readTag)
/*     */             {
/* 756 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 758 */             xbean.GangTeamApplicants _v_ = xbean.Pod.newGangTeamApplicantsData();
/* 759 */             _input_.readMessage(_v_);
/* 760 */             this.teamapplicants.put(Long.valueOf(_k_), _v_);
/* 761 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 765 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 767 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 776 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (java.io.IOException e)
/*     */       {
/* 780 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 782 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GangMemoryBean copy()
/*     */     {
/* 788 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GangMemoryBean toData()
/*     */     {
/* 794 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.GangMemoryBean toBean()
/*     */     {
/* 799 */       return new GangMemoryBean(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GangMemoryBean toDataIf()
/*     */     {
/* 805 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.GangMemoryBean toBeanIf()
/*     */     {
/* 810 */       return new GangMemoryBean(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 816 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 820 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 824 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 828 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 832 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 836 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 840 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.GangApply> getApplylist()
/*     */     {
/* 847 */       return this.applylist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.GangApply> getApplylistAsData()
/*     */     {
/* 854 */       return this.applylist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getGangworldid()
/*     */     {
/* 861 */       return this.gangworldid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.GangTeamApplicants> getTeamapplicants()
/*     */     {
/* 868 */       return this.teamapplicants;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.GangTeamApplicants> getTeamapplicantsAsData()
/*     */     {
/* 875 */       return this.teamapplicants;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGangworldid(long _v_)
/*     */     {
/* 882 */       this.gangworldid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 888 */       if (!(_o1_ instanceof Data)) return false;
/* 889 */       Data _o_ = (Data)_o1_;
/* 890 */       if (!this.applylist.equals(_o_.applylist)) return false;
/* 891 */       if (this.gangworldid != _o_.gangworldid) return false;
/* 892 */       if (!this.teamapplicants.equals(_o_.teamapplicants)) return false;
/* 893 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 899 */       int _h_ = 0;
/* 900 */       _h_ += this.applylist.hashCode();
/* 901 */       _h_ = (int)(_h_ + this.gangworldid);
/* 902 */       _h_ += this.teamapplicants.hashCode();
/* 903 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 909 */       StringBuilder _sb_ = new StringBuilder();
/* 910 */       _sb_.append("(");
/* 911 */       _sb_.append(this.applylist);
/* 912 */       _sb_.append(",");
/* 913 */       _sb_.append(this.gangworldid);
/* 914 */       _sb_.append(",");
/* 915 */       _sb_.append(this.teamapplicants);
/* 916 */       _sb_.append(")");
/* 917 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\GangMemoryBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */