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
/*     */ 
/*     */ public final class CrossLadderLevelRangeRankBackup extends xdb.XBean implements xbean.CrossLadderLevelRangeRankBackup
/*     */ {
/*     */   private LinkedList<Long> local_rank_list;
/*     */   private HashMap<Integer, xbean.CrossLadderRankAwardInfo> rank_award_infos;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.local_rank_list.clear();
/*  21 */     this.rank_award_infos.clear();
/*     */   }
/*     */   
/*     */   CrossLadderLevelRangeRankBackup(int __, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.local_rank_list = new LinkedList();
/*  28 */     this.rank_award_infos = new HashMap();
/*     */   }
/*     */   
/*     */   public CrossLadderLevelRangeRankBackup()
/*     */   {
/*  33 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public CrossLadderLevelRangeRankBackup(CrossLadderLevelRangeRankBackup _o_)
/*     */   {
/*  38 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   CrossLadderLevelRangeRankBackup(xbean.CrossLadderLevelRangeRankBackup _o1_, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  43 */     super(_xp_, _vn_);
/*  44 */     if ((_o1_ instanceof CrossLadderLevelRangeRankBackup)) { assign((CrossLadderLevelRangeRankBackup)_o1_);
/*  45 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  46 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  47 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(CrossLadderLevelRangeRankBackup _o_) {
/*  52 */     _o_._xdb_verify_unsafe_();
/*  53 */     this.local_rank_list = new LinkedList();
/*  54 */     this.local_rank_list.addAll(_o_.local_rank_list);
/*  55 */     this.rank_award_infos = new HashMap();
/*  56 */     for (Map.Entry<Integer, xbean.CrossLadderRankAwardInfo> _e_ : _o_.rank_award_infos.entrySet()) {
/*  57 */       this.rank_award_infos.put(_e_.getKey(), new CrossLadderRankAwardInfo((xbean.CrossLadderRankAwardInfo)_e_.getValue(), this, "rank_award_infos"));
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  62 */     this.local_rank_list = new LinkedList();
/*  63 */     this.local_rank_list.addAll(_o_.local_rank_list);
/*  64 */     this.rank_award_infos = new HashMap();
/*  65 */     for (Map.Entry<Integer, xbean.CrossLadderRankAwardInfo> _e_ : _o_.rank_award_infos.entrySet()) {
/*  66 */       this.rank_award_infos.put(_e_.getKey(), new CrossLadderRankAwardInfo((xbean.CrossLadderRankAwardInfo)_e_.getValue(), this, "rank_award_infos"));
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  72 */     _xdb_verify_unsafe_();
/*  73 */     _os_.compact_uint32(this.local_rank_list.size());
/*  74 */     for (Long _v_ : this.local_rank_list)
/*     */     {
/*  76 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  78 */     _os_.compact_uint32(this.rank_award_infos.size());
/*  79 */     for (Map.Entry<Integer, xbean.CrossLadderRankAwardInfo> _e_ : this.rank_award_infos.entrySet())
/*     */     {
/*  81 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  82 */       ((xbean.CrossLadderRankAwardInfo)_e_.getValue()).marshal(_os_);
/*     */     }
/*  84 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  90 */     _xdb_verify_unsafe_();
/*  91 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  93 */       long _v_ = 0L;
/*  94 */       _v_ = _os_.unmarshal_long();
/*  95 */       this.local_rank_list.add(Long.valueOf(_v_));
/*     */     }
/*     */     
/*  98 */     int size = _os_.uncompact_uint32();
/*  99 */     if (size >= 12)
/*     */     {
/* 101 */       this.rank_award_infos = new HashMap(size * 2);
/*     */     }
/* 103 */     for (; size > 0; size--)
/*     */     {
/* 105 */       int _k_ = 0;
/* 106 */       _k_ = _os_.unmarshal_int();
/* 107 */       xbean.CrossLadderRankAwardInfo _v_ = new CrossLadderRankAwardInfo(0, this, "rank_award_infos");
/* 108 */       _v_.unmarshal(_os_);
/* 109 */       this.rank_award_infos.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*     */     
/* 112 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 118 */     _xdb_verify_unsafe_();
/* 119 */     int _size_ = 0;
/* 120 */     for (Long _v_ : this.local_rank_list)
/*     */     {
/* 122 */       _size_ += CodedOutputStream.computeInt64Size(1, _v_.longValue());
/*     */     }
/* 124 */     for (Map.Entry<Integer, xbean.CrossLadderRankAwardInfo> _e_ : this.rank_award_infos.entrySet())
/*     */     {
/* 126 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/* 127 */       _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*     */     }
/* 129 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 135 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 138 */       for (Long _v_ : this.local_rank_list)
/*     */       {
/* 140 */         _output_.writeInt64(1, _v_.longValue());
/*     */       }
/* 142 */       for (Map.Entry<Integer, xbean.CrossLadderRankAwardInfo> _e_ : this.rank_award_infos.entrySet())
/*     */       {
/* 144 */         _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/* 145 */         _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*     */       }
/*     */     }
/*     */     catch (java.io.IOException e)
/*     */     {
/* 150 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 152 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 158 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 161 */       boolean done = false;
/* 162 */       while (!done)
/*     */       {
/* 164 */         int tag = _input_.readTag();
/* 165 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 169 */           done = true;
/* 170 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 174 */           long _v_ = 0L;
/* 175 */           _v_ = _input_.readInt64();
/* 176 */           this.local_rank_list.add(Long.valueOf(_v_));
/* 177 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 181 */           int _k_ = 0;
/* 182 */           _k_ = _input_.readInt32();
/* 183 */           int readTag = _input_.readTag();
/* 184 */           if (18 != readTag)
/*     */           {
/* 186 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 188 */           xbean.CrossLadderRankAwardInfo _v_ = new CrossLadderRankAwardInfo(0, this, "rank_award_infos");
/* 189 */           _input_.readMessage(_v_);
/* 190 */           this.rank_award_infos.put(Integer.valueOf(_k_), _v_);
/* 191 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 195 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 197 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 206 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (java.io.IOException e)
/*     */     {
/* 210 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 212 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CrossLadderLevelRangeRankBackup copy()
/*     */   {
/* 218 */     _xdb_verify_unsafe_();
/* 219 */     return new CrossLadderLevelRangeRankBackup(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CrossLadderLevelRangeRankBackup toData()
/*     */   {
/* 225 */     _xdb_verify_unsafe_();
/* 226 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.CrossLadderLevelRangeRankBackup toBean()
/*     */   {
/* 231 */     _xdb_verify_unsafe_();
/* 232 */     return new CrossLadderLevelRangeRankBackup(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CrossLadderLevelRangeRankBackup toDataIf()
/*     */   {
/* 238 */     _xdb_verify_unsafe_();
/* 239 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.CrossLadderLevelRangeRankBackup toBeanIf()
/*     */   {
/* 244 */     _xdb_verify_unsafe_();
/* 245 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 251 */     _xdb_verify_unsafe_();
/* 252 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Long> getLocal_rank_list()
/*     */   {
/* 259 */     _xdb_verify_unsafe_();
/* 260 */     return xdb.Logs.logList(new xdb.LogKey(this, "local_rank_list"), this.local_rank_list);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Long> getLocal_rank_listAsData()
/*     */   {
/* 266 */     _xdb_verify_unsafe_();
/*     */     
/* 268 */     CrossLadderLevelRangeRankBackup _o_ = this;
/* 269 */     List<Long> local_rank_list = new LinkedList();
/* 270 */     local_rank_list.addAll(_o_.local_rank_list);
/* 271 */     return local_rank_list;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.CrossLadderRankAwardInfo> getRank_award_infos()
/*     */   {
/* 278 */     _xdb_verify_unsafe_();
/* 279 */     return xdb.Logs.logMap(new xdb.LogKey(this, "rank_award_infos"), this.rank_award_infos);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.CrossLadderRankAwardInfo> getRank_award_infosAsData()
/*     */   {
/* 286 */     _xdb_verify_unsafe_();
/*     */     
/* 288 */     CrossLadderLevelRangeRankBackup _o_ = this;
/* 289 */     Map<Integer, xbean.CrossLadderRankAwardInfo> rank_award_infos = new HashMap();
/* 290 */     for (Map.Entry<Integer, xbean.CrossLadderRankAwardInfo> _e_ : _o_.rank_award_infos.entrySet())
/* 291 */       rank_award_infos.put(_e_.getKey(), new CrossLadderRankAwardInfo.Data((xbean.CrossLadderRankAwardInfo)_e_.getValue()));
/* 292 */     return rank_award_infos;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 298 */     _xdb_verify_unsafe_();
/* 299 */     CrossLadderLevelRangeRankBackup _o_ = null;
/* 300 */     if ((_o1_ instanceof CrossLadderLevelRangeRankBackup)) { _o_ = (CrossLadderLevelRangeRankBackup)_o1_;
/* 301 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 302 */       return false;
/* 303 */     if (!this.local_rank_list.equals(_o_.local_rank_list)) return false;
/* 304 */     if (!this.rank_award_infos.equals(_o_.rank_award_infos)) return false;
/* 305 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 311 */     _xdb_verify_unsafe_();
/* 312 */     int _h_ = 0;
/* 313 */     _h_ += this.local_rank_list.hashCode();
/* 314 */     _h_ += this.rank_award_infos.hashCode();
/* 315 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 321 */     _xdb_verify_unsafe_();
/* 322 */     StringBuilder _sb_ = new StringBuilder();
/* 323 */     _sb_.append("(");
/* 324 */     _sb_.append(this.local_rank_list);
/* 325 */     _sb_.append(",");
/* 326 */     _sb_.append(this.rank_award_infos);
/* 327 */     _sb_.append(")");
/* 328 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 334 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 335 */     lb.add(new xdb.logs.ListenableChanged().setVarName("local_rank_list"));
/* 336 */     lb.add(new xdb.logs.ListenableMap().setVarName("rank_award_infos"));
/* 337 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.CrossLadderLevelRangeRankBackup {
/*     */     private Const() {}
/*     */     
/*     */     CrossLadderLevelRangeRankBackup nThis() {
/* 344 */       return CrossLadderLevelRangeRankBackup.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 350 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossLadderLevelRangeRankBackup copy()
/*     */     {
/* 356 */       return CrossLadderLevelRangeRankBackup.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossLadderLevelRangeRankBackup toData()
/*     */     {
/* 362 */       return CrossLadderLevelRangeRankBackup.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.CrossLadderLevelRangeRankBackup toBean()
/*     */     {
/* 367 */       return CrossLadderLevelRangeRankBackup.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossLadderLevelRangeRankBackup toDataIf()
/*     */     {
/* 373 */       return CrossLadderLevelRangeRankBackup.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.CrossLadderLevelRangeRankBackup toBeanIf()
/*     */     {
/* 378 */       return CrossLadderLevelRangeRankBackup.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getLocal_rank_list()
/*     */     {
/* 385 */       CrossLadderLevelRangeRankBackup.this._xdb_verify_unsafe_();
/* 386 */       return xdb.Consts.constList(CrossLadderLevelRangeRankBackup.this.local_rank_list);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<Long> getLocal_rank_listAsData()
/*     */     {
/* 392 */       CrossLadderLevelRangeRankBackup.this._xdb_verify_unsafe_();
/*     */       
/* 394 */       CrossLadderLevelRangeRankBackup _o_ = CrossLadderLevelRangeRankBackup.this;
/* 395 */       List<Long> local_rank_list = new LinkedList();
/* 396 */       local_rank_list.addAll(_o_.local_rank_list);
/* 397 */       return local_rank_list;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.CrossLadderRankAwardInfo> getRank_award_infos()
/*     */     {
/* 404 */       CrossLadderLevelRangeRankBackup.this._xdb_verify_unsafe_();
/* 405 */       return xdb.Consts.constMap(CrossLadderLevelRangeRankBackup.this.rank_award_infos);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.CrossLadderRankAwardInfo> getRank_award_infosAsData()
/*     */     {
/* 412 */       CrossLadderLevelRangeRankBackup.this._xdb_verify_unsafe_();
/*     */       
/* 414 */       CrossLadderLevelRangeRankBackup _o_ = CrossLadderLevelRangeRankBackup.this;
/* 415 */       Map<Integer, xbean.CrossLadderRankAwardInfo> rank_award_infos = new HashMap();
/* 416 */       for (Map.Entry<Integer, xbean.CrossLadderRankAwardInfo> _e_ : _o_.rank_award_infos.entrySet())
/* 417 */         rank_award_infos.put(_e_.getKey(), new CrossLadderRankAwardInfo.Data((xbean.CrossLadderRankAwardInfo)_e_.getValue()));
/* 418 */       return rank_award_infos;
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 424 */       CrossLadderLevelRangeRankBackup.this._xdb_verify_unsafe_();
/* 425 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 431 */       CrossLadderLevelRangeRankBackup.this._xdb_verify_unsafe_();
/* 432 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 438 */       return CrossLadderLevelRangeRankBackup.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 444 */       return CrossLadderLevelRangeRankBackup.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 450 */       CrossLadderLevelRangeRankBackup.this._xdb_verify_unsafe_();
/* 451 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 457 */       return CrossLadderLevelRangeRankBackup.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 463 */       return CrossLadderLevelRangeRankBackup.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 469 */       CrossLadderLevelRangeRankBackup.this._xdb_verify_unsafe_();
/* 470 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 476 */       return CrossLadderLevelRangeRankBackup.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 482 */       return CrossLadderLevelRangeRankBackup.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 488 */       return CrossLadderLevelRangeRankBackup.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 494 */       return CrossLadderLevelRangeRankBackup.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 500 */       return CrossLadderLevelRangeRankBackup.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 506 */       return CrossLadderLevelRangeRankBackup.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 512 */       return CrossLadderLevelRangeRankBackup.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.CrossLadderLevelRangeRankBackup
/*     */   {
/*     */     private LinkedList<Long> local_rank_list;
/*     */     
/*     */     private HashMap<Integer, xbean.CrossLadderRankAwardInfo> rank_award_infos;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 526 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 531 */       this.local_rank_list = new LinkedList();
/* 532 */       this.rank_award_infos = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.CrossLadderLevelRangeRankBackup _o1_)
/*     */     {
/* 537 */       if ((_o1_ instanceof CrossLadderLevelRangeRankBackup)) { assign((CrossLadderLevelRangeRankBackup)_o1_);
/* 538 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 539 */       } else if ((_o1_ instanceof CrossLadderLevelRangeRankBackup.Const)) assign(((CrossLadderLevelRangeRankBackup.Const)_o1_).nThis()); else {
/* 540 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(CrossLadderLevelRangeRankBackup _o_) {
/* 545 */       this.local_rank_list = new LinkedList();
/* 546 */       this.local_rank_list.addAll(_o_.local_rank_list);
/* 547 */       this.rank_award_infos = new HashMap();
/* 548 */       for (Map.Entry<Integer, xbean.CrossLadderRankAwardInfo> _e_ : _o_.rank_award_infos.entrySet()) {
/* 549 */         this.rank_award_infos.put(_e_.getKey(), new CrossLadderRankAwardInfo.Data((xbean.CrossLadderRankAwardInfo)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 554 */       this.local_rank_list = new LinkedList();
/* 555 */       this.local_rank_list.addAll(_o_.local_rank_list);
/* 556 */       this.rank_award_infos = new HashMap();
/* 557 */       for (Map.Entry<Integer, xbean.CrossLadderRankAwardInfo> _e_ : _o_.rank_award_infos.entrySet()) {
/* 558 */         this.rank_award_infos.put(_e_.getKey(), new CrossLadderRankAwardInfo.Data((xbean.CrossLadderRankAwardInfo)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 564 */       _os_.compact_uint32(this.local_rank_list.size());
/* 565 */       for (Long _v_ : this.local_rank_list)
/*     */       {
/* 567 */         _os_.marshal(_v_.longValue());
/*     */       }
/* 569 */       _os_.compact_uint32(this.rank_award_infos.size());
/* 570 */       for (Map.Entry<Integer, xbean.CrossLadderRankAwardInfo> _e_ : this.rank_award_infos.entrySet())
/*     */       {
/* 572 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 573 */         ((xbean.CrossLadderRankAwardInfo)_e_.getValue()).marshal(_os_);
/*     */       }
/* 575 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 581 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 583 */         long _v_ = 0L;
/* 584 */         _v_ = _os_.unmarshal_long();
/* 585 */         this.local_rank_list.add(Long.valueOf(_v_));
/*     */       }
/*     */       
/* 588 */       int size = _os_.uncompact_uint32();
/* 589 */       if (size >= 12)
/*     */       {
/* 591 */         this.rank_award_infos = new HashMap(size * 2);
/*     */       }
/* 593 */       for (; size > 0; size--)
/*     */       {
/* 595 */         int _k_ = 0;
/* 596 */         _k_ = _os_.unmarshal_int();
/* 597 */         xbean.CrossLadderRankAwardInfo _v_ = xbean.Pod.newCrossLadderRankAwardInfoData();
/* 598 */         _v_.unmarshal(_os_);
/* 599 */         this.rank_award_infos.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 602 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 608 */       int _size_ = 0;
/* 609 */       for (Long _v_ : this.local_rank_list)
/*     */       {
/* 611 */         _size_ += CodedOutputStream.computeInt64Size(1, _v_.longValue());
/*     */       }
/* 613 */       for (Map.Entry<Integer, xbean.CrossLadderRankAwardInfo> _e_ : this.rank_award_infos.entrySet())
/*     */       {
/* 615 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/* 616 */         _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*     */       }
/* 618 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 626 */         for (Long _v_ : this.local_rank_list)
/*     */         {
/* 628 */           _output_.writeInt64(1, _v_.longValue());
/*     */         }
/* 630 */         for (Map.Entry<Integer, xbean.CrossLadderRankAwardInfo> _e_ : this.rank_award_infos.entrySet())
/*     */         {
/* 632 */           _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/* 633 */           _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*     */         }
/*     */       }
/*     */       catch (java.io.IOException e)
/*     */       {
/* 638 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 640 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 648 */         boolean done = false;
/* 649 */         while (!done)
/*     */         {
/* 651 */           int tag = _input_.readTag();
/* 652 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 656 */             done = true;
/* 657 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 661 */             long _v_ = 0L;
/* 662 */             _v_ = _input_.readInt64();
/* 663 */             this.local_rank_list.add(Long.valueOf(_v_));
/* 664 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 668 */             int _k_ = 0;
/* 669 */             _k_ = _input_.readInt32();
/* 670 */             int readTag = _input_.readTag();
/* 671 */             if (18 != readTag)
/*     */             {
/* 673 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 675 */             xbean.CrossLadderRankAwardInfo _v_ = xbean.Pod.newCrossLadderRankAwardInfoData();
/* 676 */             _input_.readMessage(_v_);
/* 677 */             this.rank_award_infos.put(Integer.valueOf(_k_), _v_);
/* 678 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 682 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 684 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 693 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (java.io.IOException e)
/*     */       {
/* 697 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 699 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossLadderLevelRangeRankBackup copy()
/*     */     {
/* 705 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossLadderLevelRangeRankBackup toData()
/*     */     {
/* 711 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.CrossLadderLevelRangeRankBackup toBean()
/*     */     {
/* 716 */       return new CrossLadderLevelRangeRankBackup(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossLadderLevelRangeRankBackup toDataIf()
/*     */     {
/* 722 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.CrossLadderLevelRangeRankBackup toBeanIf()
/*     */     {
/* 727 */       return new CrossLadderLevelRangeRankBackup(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 733 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 737 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 741 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 745 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 749 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 753 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 757 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getLocal_rank_list()
/*     */     {
/* 764 */       return this.local_rank_list;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getLocal_rank_listAsData()
/*     */     {
/* 771 */       return this.local_rank_list;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.CrossLadderRankAwardInfo> getRank_award_infos()
/*     */     {
/* 778 */       return this.rank_award_infos;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.CrossLadderRankAwardInfo> getRank_award_infosAsData()
/*     */     {
/* 785 */       return this.rank_award_infos;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 791 */       if (!(_o1_ instanceof Data)) return false;
/* 792 */       Data _o_ = (Data)_o1_;
/* 793 */       if (!this.local_rank_list.equals(_o_.local_rank_list)) return false;
/* 794 */       if (!this.rank_award_infos.equals(_o_.rank_award_infos)) return false;
/* 795 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 801 */       int _h_ = 0;
/* 802 */       _h_ += this.local_rank_list.hashCode();
/* 803 */       _h_ += this.rank_award_infos.hashCode();
/* 804 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 810 */       StringBuilder _sb_ = new StringBuilder();
/* 811 */       _sb_.append("(");
/* 812 */       _sb_.append(this.local_rank_list);
/* 813 */       _sb_.append(",");
/* 814 */       _sb_.append(this.rank_award_infos);
/* 815 */       _sb_.append(")");
/* 816 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\CrossLadderLevelRangeRankBackup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */