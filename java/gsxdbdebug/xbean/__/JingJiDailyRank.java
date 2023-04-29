/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class JingJiDailyRank extends XBean implements xbean.JingJiDailyRank
/*     */ {
/*     */   private LinkedList<xbean.RoleJingJiBean> rank_datas;
/*     */   private long time;
/*     */   private HashMap<Long, Integer> role_ranks;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.rank_datas.clear();
/*  23 */     this.time = 0L;
/*  24 */     this.role_ranks.clear();
/*     */   }
/*     */   
/*     */   JingJiDailyRank(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.rank_datas = new LinkedList();
/*  31 */     this.role_ranks = new HashMap();
/*     */   }
/*     */   
/*     */   public JingJiDailyRank()
/*     */   {
/*  36 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public JingJiDailyRank(JingJiDailyRank _o_)
/*     */   {
/*  41 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   JingJiDailyRank(xbean.JingJiDailyRank _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  46 */     super(_xp_, _vn_);
/*  47 */     if ((_o1_ instanceof JingJiDailyRank)) { assign((JingJiDailyRank)_o1_);
/*  48 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  49 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  50 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(JingJiDailyRank _o_) {
/*  55 */     _o_._xdb_verify_unsafe_();
/*  56 */     this.rank_datas = new LinkedList();
/*  57 */     for (xbean.RoleJingJiBean _v_ : _o_.rank_datas)
/*  58 */       this.rank_datas.add(new RoleJingJiBean(_v_, this, "rank_datas"));
/*  59 */     this.time = _o_.time;
/*  60 */     this.role_ranks = new HashMap();
/*  61 */     for (Map.Entry<Long, Integer> _e_ : _o_.role_ranks.entrySet()) {
/*  62 */       this.role_ranks.put(_e_.getKey(), _e_.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  67 */     this.rank_datas = new LinkedList();
/*  68 */     for (xbean.RoleJingJiBean _v_ : _o_.rank_datas)
/*  69 */       this.rank_datas.add(new RoleJingJiBean(_v_, this, "rank_datas"));
/*  70 */     this.time = _o_.time;
/*  71 */     this.role_ranks = new HashMap();
/*  72 */     for (Map.Entry<Long, Integer> _e_ : _o_.role_ranks.entrySet()) {
/*  73 */       this.role_ranks.put(_e_.getKey(), _e_.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  79 */     _xdb_verify_unsafe_();
/*  80 */     _os_.compact_uint32(this.rank_datas.size());
/*  81 */     for (xbean.RoleJingJiBean _v_ : this.rank_datas)
/*     */     {
/*  83 */       _v_.marshal(_os_);
/*     */     }
/*  85 */     _os_.marshal(this.time);
/*  86 */     _os_.compact_uint32(this.role_ranks.size());
/*  87 */     for (Map.Entry<Long, Integer> _e_ : this.role_ranks.entrySet())
/*     */     {
/*  89 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  90 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
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
/* 101 */       xbean.RoleJingJiBean _v_ = new RoleJingJiBean(0, this, "rank_datas");
/* 102 */       _v_.unmarshal(_os_);
/* 103 */       this.rank_datas.add(_v_);
/*     */     }
/* 105 */     this.time = _os_.unmarshal_long();
/*     */     
/* 107 */     int size = _os_.uncompact_uint32();
/* 108 */     if (size >= 12)
/*     */     {
/* 110 */       this.role_ranks = new HashMap(size * 2);
/*     */     }
/* 112 */     for (; size > 0; size--)
/*     */     {
/* 114 */       long _k_ = 0L;
/* 115 */       _k_ = _os_.unmarshal_long();
/* 116 */       int _v_ = 0;
/* 117 */       _v_ = _os_.unmarshal_int();
/* 118 */       this.role_ranks.put(Long.valueOf(_k_), Integer.valueOf(_v_));
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
/* 129 */     for (xbean.RoleJingJiBean _v_ : this.rank_datas)
/*     */     {
/* 131 */       _size_ += CodedOutputStream.computeMessageSize(1, _v_);
/*     */     }
/* 133 */     _size_ += CodedOutputStream.computeInt64Size(2, this.time);
/* 134 */     for (Map.Entry<Long, Integer> _e_ : this.role_ranks.entrySet())
/*     */     {
/* 136 */       _size_ += CodedOutputStream.computeInt64Size(3, ((Long)_e_.getKey()).longValue());
/* 137 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getValue()).intValue());
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
/* 148 */       for (xbean.RoleJingJiBean _v_ : this.rank_datas)
/*     */       {
/* 150 */         _output_.writeMessage(1, _v_);
/*     */       }
/* 152 */       _output_.writeInt64(2, this.time);
/* 153 */       for (Map.Entry<Long, Integer> _e_ : this.role_ranks.entrySet())
/*     */       {
/* 155 */         _output_.writeInt64(3, ((Long)_e_.getKey()).longValue());
/* 156 */         _output_.writeInt32(3, ((Integer)_e_.getValue()).intValue());
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
/* 185 */           xbean.RoleJingJiBean _v_ = new RoleJingJiBean(0, this, "rank_datas");
/* 186 */           _input_.readMessage(_v_);
/* 187 */           this.rank_datas.add(_v_);
/* 188 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 192 */           this.time = _input_.readInt64();
/* 193 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 197 */           long _k_ = 0L;
/* 198 */           _k_ = _input_.readInt64();
/* 199 */           int readTag = _input_.readTag();
/* 200 */           if (24 != readTag)
/*     */           {
/* 202 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 204 */           int _v_ = 0;
/* 205 */           _v_ = _input_.readInt32();
/* 206 */           this.role_ranks.put(Long.valueOf(_k_), Integer.valueOf(_v_));
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
/*     */   public xbean.JingJiDailyRank copy()
/*     */   {
/* 234 */     _xdb_verify_unsafe_();
/* 235 */     return new JingJiDailyRank(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.JingJiDailyRank toData()
/*     */   {
/* 241 */     _xdb_verify_unsafe_();
/* 242 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.JingJiDailyRank toBean()
/*     */   {
/* 247 */     _xdb_verify_unsafe_();
/* 248 */     return new JingJiDailyRank(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.JingJiDailyRank toDataIf()
/*     */   {
/* 254 */     _xdb_verify_unsafe_();
/* 255 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.JingJiDailyRank toBeanIf()
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
/*     */   public List<xbean.RoleJingJiBean> getRank_datas()
/*     */   {
/* 275 */     _xdb_verify_unsafe_();
/* 276 */     return xdb.Logs.logList(new xdb.LogKey(this, "rank_datas"), this.rank_datas);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<xbean.RoleJingJiBean> getRank_datasAsData()
/*     */   {
/* 282 */     _xdb_verify_unsafe_();
/*     */     
/* 284 */     JingJiDailyRank _o_ = this;
/* 285 */     List<xbean.RoleJingJiBean> rank_datas = new LinkedList();
/* 286 */     for (xbean.RoleJingJiBean _v_ : _o_.rank_datas)
/* 287 */       rank_datas.add(new RoleJingJiBean.Data(_v_));
/* 288 */     return rank_datas;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getTime()
/*     */   {
/* 295 */     _xdb_verify_unsafe_();
/* 296 */     return this.time;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, Integer> getRole_ranks()
/*     */   {
/* 303 */     _xdb_verify_unsafe_();
/* 304 */     return xdb.Logs.logMap(new xdb.LogKey(this, "role_ranks"), this.role_ranks);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, Integer> getRole_ranksAsData()
/*     */   {
/* 311 */     _xdb_verify_unsafe_();
/*     */     
/* 313 */     JingJiDailyRank _o_ = this;
/* 314 */     Map<Long, Integer> role_ranks = new HashMap();
/* 315 */     for (Map.Entry<Long, Integer> _e_ : _o_.role_ranks.entrySet())
/* 316 */       role_ranks.put(_e_.getKey(), _e_.getValue());
/* 317 */     return role_ranks;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTime(long _v_)
/*     */   {
/* 324 */     _xdb_verify_unsafe_();
/* 325 */     xdb.Logs.logIf(new xdb.LogKey(this, "time")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 329 */         new xdb.logs.LogLong(this, JingJiDailyRank.this.time)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 333 */             JingJiDailyRank.this.time = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 337 */     });
/* 338 */     this.time = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 344 */     _xdb_verify_unsafe_();
/* 345 */     JingJiDailyRank _o_ = null;
/* 346 */     if ((_o1_ instanceof JingJiDailyRank)) { _o_ = (JingJiDailyRank)_o1_;
/* 347 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 348 */       return false;
/* 349 */     if (!this.rank_datas.equals(_o_.rank_datas)) return false;
/* 350 */     if (this.time != _o_.time) return false;
/* 351 */     if (!this.role_ranks.equals(_o_.role_ranks)) return false;
/* 352 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 358 */     _xdb_verify_unsafe_();
/* 359 */     int _h_ = 0;
/* 360 */     _h_ += this.rank_datas.hashCode();
/* 361 */     _h_ = (int)(_h_ + this.time);
/* 362 */     _h_ += this.role_ranks.hashCode();
/* 363 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 369 */     _xdb_verify_unsafe_();
/* 370 */     StringBuilder _sb_ = new StringBuilder();
/* 371 */     _sb_.append("(");
/* 372 */     _sb_.append(this.rank_datas);
/* 373 */     _sb_.append(",");
/* 374 */     _sb_.append(this.time);
/* 375 */     _sb_.append(",");
/* 376 */     _sb_.append(this.role_ranks);
/* 377 */     _sb_.append(")");
/* 378 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 384 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 385 */     lb.add(new xdb.logs.ListenableChanged().setVarName("rank_datas"));
/* 386 */     lb.add(new xdb.logs.ListenableChanged().setVarName("time"));
/* 387 */     lb.add(new xdb.logs.ListenableMap().setVarName("role_ranks"));
/* 388 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.JingJiDailyRank {
/*     */     private Const() {}
/*     */     
/*     */     JingJiDailyRank nThis() {
/* 395 */       return JingJiDailyRank.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 401 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.JingJiDailyRank copy()
/*     */     {
/* 407 */       return JingJiDailyRank.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.JingJiDailyRank toData()
/*     */     {
/* 413 */       return JingJiDailyRank.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.JingJiDailyRank toBean()
/*     */     {
/* 418 */       return JingJiDailyRank.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.JingJiDailyRank toDataIf()
/*     */     {
/* 424 */       return JingJiDailyRank.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.JingJiDailyRank toBeanIf()
/*     */     {
/* 429 */       return JingJiDailyRank.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.RoleJingJiBean> getRank_datas()
/*     */     {
/* 436 */       JingJiDailyRank.this._xdb_verify_unsafe_();
/* 437 */       return xdb.Consts.constList(JingJiDailyRank.this.rank_datas);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<xbean.RoleJingJiBean> getRank_datasAsData()
/*     */     {
/* 443 */       JingJiDailyRank.this._xdb_verify_unsafe_();
/*     */       
/* 445 */       JingJiDailyRank _o_ = JingJiDailyRank.this;
/* 446 */       List<xbean.RoleJingJiBean> rank_datas = new LinkedList();
/* 447 */       for (xbean.RoleJingJiBean _v_ : _o_.rank_datas)
/* 448 */         rank_datas.add(new RoleJingJiBean.Data(_v_));
/* 449 */       return rank_datas;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getTime()
/*     */     {
/* 456 */       JingJiDailyRank.this._xdb_verify_unsafe_();
/* 457 */       return JingJiDailyRank.this.time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, Integer> getRole_ranks()
/*     */     {
/* 464 */       JingJiDailyRank.this._xdb_verify_unsafe_();
/* 465 */       return xdb.Consts.constMap(JingJiDailyRank.this.role_ranks);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, Integer> getRole_ranksAsData()
/*     */     {
/* 472 */       JingJiDailyRank.this._xdb_verify_unsafe_();
/*     */       
/* 474 */       JingJiDailyRank _o_ = JingJiDailyRank.this;
/* 475 */       Map<Long, Integer> role_ranks = new HashMap();
/* 476 */       for (Map.Entry<Long, Integer> _e_ : _o_.role_ranks.entrySet())
/* 477 */         role_ranks.put(_e_.getKey(), _e_.getValue());
/* 478 */       return role_ranks;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTime(long _v_)
/*     */     {
/* 485 */       JingJiDailyRank.this._xdb_verify_unsafe_();
/* 486 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 492 */       JingJiDailyRank.this._xdb_verify_unsafe_();
/* 493 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 499 */       JingJiDailyRank.this._xdb_verify_unsafe_();
/* 500 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 506 */       return JingJiDailyRank.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 512 */       return JingJiDailyRank.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 518 */       JingJiDailyRank.this._xdb_verify_unsafe_();
/* 519 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 525 */       return JingJiDailyRank.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 531 */       return JingJiDailyRank.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 537 */       JingJiDailyRank.this._xdb_verify_unsafe_();
/* 538 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 544 */       return JingJiDailyRank.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 550 */       return JingJiDailyRank.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 556 */       return JingJiDailyRank.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 562 */       return JingJiDailyRank.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 568 */       return JingJiDailyRank.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 574 */       return JingJiDailyRank.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 580 */       return JingJiDailyRank.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.JingJiDailyRank
/*     */   {
/*     */     private LinkedList<xbean.RoleJingJiBean> rank_datas;
/*     */     
/*     */     private long time;
/*     */     
/*     */     private HashMap<Long, Integer> role_ranks;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 596 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 601 */       this.rank_datas = new LinkedList();
/* 602 */       this.role_ranks = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.JingJiDailyRank _o1_)
/*     */     {
/* 607 */       if ((_o1_ instanceof JingJiDailyRank)) { assign((JingJiDailyRank)_o1_);
/* 608 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 609 */       } else if ((_o1_ instanceof JingJiDailyRank.Const)) assign(((JingJiDailyRank.Const)_o1_).nThis()); else {
/* 610 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(JingJiDailyRank _o_) {
/* 615 */       this.rank_datas = new LinkedList();
/* 616 */       for (xbean.RoleJingJiBean _v_ : _o_.rank_datas)
/* 617 */         this.rank_datas.add(new RoleJingJiBean.Data(_v_));
/* 618 */       this.time = _o_.time;
/* 619 */       this.role_ranks = new HashMap();
/* 620 */       for (Map.Entry<Long, Integer> _e_ : _o_.role_ranks.entrySet()) {
/* 621 */         this.role_ranks.put(_e_.getKey(), _e_.getValue());
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 626 */       this.rank_datas = new LinkedList();
/* 627 */       for (xbean.RoleJingJiBean _v_ : _o_.rank_datas)
/* 628 */         this.rank_datas.add(new RoleJingJiBean.Data(_v_));
/* 629 */       this.time = _o_.time;
/* 630 */       this.role_ranks = new HashMap();
/* 631 */       for (Map.Entry<Long, Integer> _e_ : _o_.role_ranks.entrySet()) {
/* 632 */         this.role_ranks.put(_e_.getKey(), _e_.getValue());
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 638 */       _os_.compact_uint32(this.rank_datas.size());
/* 639 */       for (xbean.RoleJingJiBean _v_ : this.rank_datas)
/*     */       {
/* 641 */         _v_.marshal(_os_);
/*     */       }
/* 643 */       _os_.marshal(this.time);
/* 644 */       _os_.compact_uint32(this.role_ranks.size());
/* 645 */       for (Map.Entry<Long, Integer> _e_ : this.role_ranks.entrySet())
/*     */       {
/* 647 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 648 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */       }
/* 650 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 656 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 658 */         xbean.RoleJingJiBean _v_ = xbean.Pod.newRoleJingJiBeanData();
/* 659 */         _v_.unmarshal(_os_);
/* 660 */         this.rank_datas.add(_v_);
/*     */       }
/* 662 */       this.time = _os_.unmarshal_long();
/*     */       
/* 664 */       int size = _os_.uncompact_uint32();
/* 665 */       if (size >= 12)
/*     */       {
/* 667 */         this.role_ranks = new HashMap(size * 2);
/*     */       }
/* 669 */       for (; size > 0; size--)
/*     */       {
/* 671 */         long _k_ = 0L;
/* 672 */         _k_ = _os_.unmarshal_long();
/* 673 */         int _v_ = 0;
/* 674 */         _v_ = _os_.unmarshal_int();
/* 675 */         this.role_ranks.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */       
/* 678 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 684 */       int _size_ = 0;
/* 685 */       for (xbean.RoleJingJiBean _v_ : this.rank_datas)
/*     */       {
/* 687 */         _size_ += CodedOutputStream.computeMessageSize(1, _v_);
/*     */       }
/* 689 */       _size_ += CodedOutputStream.computeInt64Size(2, this.time);
/* 690 */       for (Map.Entry<Long, Integer> _e_ : this.role_ranks.entrySet())
/*     */       {
/* 692 */         _size_ += CodedOutputStream.computeInt64Size(3, ((Long)_e_.getKey()).longValue());
/* 693 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 695 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 703 */         for (xbean.RoleJingJiBean _v_ : this.rank_datas)
/*     */         {
/* 705 */           _output_.writeMessage(1, _v_);
/*     */         }
/* 707 */         _output_.writeInt64(2, this.time);
/* 708 */         for (Map.Entry<Long, Integer> _e_ : this.role_ranks.entrySet())
/*     */         {
/* 710 */           _output_.writeInt64(3, ((Long)_e_.getKey()).longValue());
/* 711 */           _output_.writeInt32(3, ((Integer)_e_.getValue()).intValue());
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
/* 739 */             xbean.RoleJingJiBean _v_ = xbean.Pod.newRoleJingJiBeanData();
/* 740 */             _input_.readMessage(_v_);
/* 741 */             this.rank_datas.add(_v_);
/* 742 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 746 */             this.time = _input_.readInt64();
/* 747 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 751 */             long _k_ = 0L;
/* 752 */             _k_ = _input_.readInt64();
/* 753 */             int readTag = _input_.readTag();
/* 754 */             if (24 != readTag)
/*     */             {
/* 756 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 758 */             int _v_ = 0;
/* 759 */             _v_ = _input_.readInt32();
/* 760 */             this.role_ranks.put(Long.valueOf(_k_), Integer.valueOf(_v_));
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
/*     */     public xbean.JingJiDailyRank copy()
/*     */     {
/* 788 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.JingJiDailyRank toData()
/*     */     {
/* 794 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.JingJiDailyRank toBean()
/*     */     {
/* 799 */       return new JingJiDailyRank(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.JingJiDailyRank toDataIf()
/*     */     {
/* 805 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.JingJiDailyRank toBeanIf()
/*     */     {
/* 810 */       return new JingJiDailyRank(this, null, null);
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
/*     */     public List<xbean.RoleJingJiBean> getRank_datas()
/*     */     {
/* 847 */       return this.rank_datas;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.RoleJingJiBean> getRank_datasAsData()
/*     */     {
/* 854 */       return this.rank_datas;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getTime()
/*     */     {
/* 861 */       return this.time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, Integer> getRole_ranks()
/*     */     {
/* 868 */       return this.role_ranks;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, Integer> getRole_ranksAsData()
/*     */     {
/* 875 */       return this.role_ranks;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTime(long _v_)
/*     */     {
/* 882 */       this.time = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 888 */       if (!(_o1_ instanceof Data)) return false;
/* 889 */       Data _o_ = (Data)_o1_;
/* 890 */       if (!this.rank_datas.equals(_o_.rank_datas)) return false;
/* 891 */       if (this.time != _o_.time) return false;
/* 892 */       if (!this.role_ranks.equals(_o_.role_ranks)) return false;
/* 893 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 899 */       int _h_ = 0;
/* 900 */       _h_ += this.rank_datas.hashCode();
/* 901 */       _h_ = (int)(_h_ + this.time);
/* 902 */       _h_ += this.role_ranks.hashCode();
/* 903 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 909 */       StringBuilder _sb_ = new StringBuilder();
/* 910 */       _sb_.append("(");
/* 911 */       _sb_.append(this.rank_datas);
/* 912 */       _sb_.append(",");
/* 913 */       _sb_.append(this.time);
/* 914 */       _sb_.append(",");
/* 915 */       _sb_.append(this.role_ranks);
/* 916 */       _sb_.append(")");
/* 917 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\JingJiDailyRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */