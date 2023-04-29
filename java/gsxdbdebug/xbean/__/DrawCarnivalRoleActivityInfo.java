/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class DrawCarnivalRoleActivityInfo extends XBean implements xbean.DrawCarnivalRoleActivityInfo
/*     */ {
/*     */   private long init_point_count;
/*     */   private HashMap<Integer, xbean.DrawCarnivalRoleFreePassInfo> free_pass_type_id2info;
/*     */   private int get_next_big_award_draw_count;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.init_point_count = 0L;
/*  23 */     this.free_pass_type_id2info.clear();
/*  24 */     this.get_next_big_award_draw_count = 0;
/*     */   }
/*     */   
/*     */   DrawCarnivalRoleActivityInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.free_pass_type_id2info = new HashMap();
/*     */   }
/*     */   
/*     */   public DrawCarnivalRoleActivityInfo()
/*     */   {
/*  35 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public DrawCarnivalRoleActivityInfo(DrawCarnivalRoleActivityInfo _o_)
/*     */   {
/*  40 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   DrawCarnivalRoleActivityInfo(xbean.DrawCarnivalRoleActivityInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  45 */     super(_xp_, _vn_);
/*  46 */     if ((_o1_ instanceof DrawCarnivalRoleActivityInfo)) { assign((DrawCarnivalRoleActivityInfo)_o1_);
/*  47 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  48 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  49 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(DrawCarnivalRoleActivityInfo _o_) {
/*  54 */     _o_._xdb_verify_unsafe_();
/*  55 */     this.init_point_count = _o_.init_point_count;
/*  56 */     this.free_pass_type_id2info = new HashMap();
/*  57 */     for (Map.Entry<Integer, xbean.DrawCarnivalRoleFreePassInfo> _e_ : _o_.free_pass_type_id2info.entrySet())
/*  58 */       this.free_pass_type_id2info.put(_e_.getKey(), new DrawCarnivalRoleFreePassInfo((xbean.DrawCarnivalRoleFreePassInfo)_e_.getValue(), this, "free_pass_type_id2info"));
/*  59 */     this.get_next_big_award_draw_count = _o_.get_next_big_award_draw_count;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  64 */     this.init_point_count = _o_.init_point_count;
/*  65 */     this.free_pass_type_id2info = new HashMap();
/*  66 */     for (Map.Entry<Integer, xbean.DrawCarnivalRoleFreePassInfo> _e_ : _o_.free_pass_type_id2info.entrySet())
/*  67 */       this.free_pass_type_id2info.put(_e_.getKey(), new DrawCarnivalRoleFreePassInfo((xbean.DrawCarnivalRoleFreePassInfo)_e_.getValue(), this, "free_pass_type_id2info"));
/*  68 */     this.get_next_big_award_draw_count = _o_.get_next_big_award_draw_count;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     _os_.marshal(this.init_point_count);
/*  76 */     _os_.compact_uint32(this.free_pass_type_id2info.size());
/*  77 */     for (Map.Entry<Integer, xbean.DrawCarnivalRoleFreePassInfo> _e_ : this.free_pass_type_id2info.entrySet())
/*     */     {
/*  79 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  80 */       ((xbean.DrawCarnivalRoleFreePassInfo)_e_.getValue()).marshal(_os_);
/*     */     }
/*  82 */     _os_.marshal(this.get_next_big_award_draw_count);
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  89 */     _xdb_verify_unsafe_();
/*  90 */     this.init_point_count = _os_.unmarshal_long();
/*     */     
/*  92 */     int size = _os_.uncompact_uint32();
/*  93 */     if (size >= 12)
/*     */     {
/*  95 */       this.free_pass_type_id2info = new HashMap(size * 2);
/*     */     }
/*  97 */     for (; size > 0; size--)
/*     */     {
/*  99 */       int _k_ = 0;
/* 100 */       _k_ = _os_.unmarshal_int();
/* 101 */       xbean.DrawCarnivalRoleFreePassInfo _v_ = new DrawCarnivalRoleFreePassInfo(0, this, "free_pass_type_id2info");
/* 102 */       _v_.unmarshal(_os_);
/* 103 */       this.free_pass_type_id2info.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*     */     
/* 106 */     this.get_next_big_award_draw_count = _os_.unmarshal_int();
/* 107 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 113 */     _xdb_verify_unsafe_();
/* 114 */     int _size_ = 0;
/* 115 */     _size_ += CodedOutputStream.computeInt64Size(1, this.init_point_count);
/* 116 */     for (Map.Entry<Integer, xbean.DrawCarnivalRoleFreePassInfo> _e_ : this.free_pass_type_id2info.entrySet())
/*     */     {
/* 118 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/* 119 */       _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*     */     }
/* 121 */     _size_ += CodedOutputStream.computeInt32Size(3, this.get_next_big_award_draw_count);
/* 122 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 128 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 131 */       _output_.writeInt64(1, this.init_point_count);
/* 132 */       for (Map.Entry<Integer, xbean.DrawCarnivalRoleFreePassInfo> _e_ : this.free_pass_type_id2info.entrySet())
/*     */       {
/* 134 */         _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/* 135 */         _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*     */       }
/* 137 */       _output_.writeInt32(3, this.get_next_big_award_draw_count);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 141 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 143 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 149 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 152 */       boolean done = false;
/* 153 */       while (!done)
/*     */       {
/* 155 */         int tag = _input_.readTag();
/* 156 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 160 */           done = true;
/* 161 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 165 */           this.init_point_count = _input_.readInt64();
/* 166 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 170 */           int _k_ = 0;
/* 171 */           _k_ = _input_.readInt32();
/* 172 */           int readTag = _input_.readTag();
/* 173 */           if (18 != readTag)
/*     */           {
/* 175 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 177 */           xbean.DrawCarnivalRoleFreePassInfo _v_ = new DrawCarnivalRoleFreePassInfo(0, this, "free_pass_type_id2info");
/* 178 */           _input_.readMessage(_v_);
/* 179 */           this.free_pass_type_id2info.put(Integer.valueOf(_k_), _v_);
/* 180 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 184 */           this.get_next_big_award_draw_count = _input_.readInt32();
/* 185 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 189 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 191 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 200 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 204 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 206 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.DrawCarnivalRoleActivityInfo copy()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return new DrawCarnivalRoleActivityInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.DrawCarnivalRoleActivityInfo toData()
/*     */   {
/* 219 */     _xdb_verify_unsafe_();
/* 220 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.DrawCarnivalRoleActivityInfo toBean()
/*     */   {
/* 225 */     _xdb_verify_unsafe_();
/* 226 */     return new DrawCarnivalRoleActivityInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.DrawCarnivalRoleActivityInfo toDataIf()
/*     */   {
/* 232 */     _xdb_verify_unsafe_();
/* 233 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.DrawCarnivalRoleActivityInfo toBeanIf()
/*     */   {
/* 238 */     _xdb_verify_unsafe_();
/* 239 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 245 */     _xdb_verify_unsafe_();
/* 246 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getInit_point_count()
/*     */   {
/* 253 */     _xdb_verify_unsafe_();
/* 254 */     return this.init_point_count;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.DrawCarnivalRoleFreePassInfo> getFree_pass_type_id2info()
/*     */   {
/* 261 */     _xdb_verify_unsafe_();
/* 262 */     return xdb.Logs.logMap(new LogKey(this, "free_pass_type_id2info"), this.free_pass_type_id2info);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.DrawCarnivalRoleFreePassInfo> getFree_pass_type_id2infoAsData()
/*     */   {
/* 269 */     _xdb_verify_unsafe_();
/*     */     
/* 271 */     DrawCarnivalRoleActivityInfo _o_ = this;
/* 272 */     Map<Integer, xbean.DrawCarnivalRoleFreePassInfo> free_pass_type_id2info = new HashMap();
/* 273 */     for (Map.Entry<Integer, xbean.DrawCarnivalRoleFreePassInfo> _e_ : _o_.free_pass_type_id2info.entrySet())
/* 274 */       free_pass_type_id2info.put(_e_.getKey(), new DrawCarnivalRoleFreePassInfo.Data((xbean.DrawCarnivalRoleFreePassInfo)_e_.getValue()));
/* 275 */     return free_pass_type_id2info;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getGet_next_big_award_draw_count()
/*     */   {
/* 282 */     _xdb_verify_unsafe_();
/* 283 */     return this.get_next_big_award_draw_count;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setInit_point_count(long _v_)
/*     */   {
/* 290 */     _xdb_verify_unsafe_();
/* 291 */     xdb.Logs.logIf(new LogKey(this, "init_point_count")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 295 */         new xdb.logs.LogLong(this, DrawCarnivalRoleActivityInfo.this.init_point_count)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 299 */             DrawCarnivalRoleActivityInfo.this.init_point_count = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 303 */     });
/* 304 */     this.init_point_count = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setGet_next_big_award_draw_count(int _v_)
/*     */   {
/* 311 */     _xdb_verify_unsafe_();
/* 312 */     xdb.Logs.logIf(new LogKey(this, "get_next_big_award_draw_count")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 316 */         new xdb.logs.LogInt(this, DrawCarnivalRoleActivityInfo.this.get_next_big_award_draw_count)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 320 */             DrawCarnivalRoleActivityInfo.this.get_next_big_award_draw_count = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 324 */     });
/* 325 */     this.get_next_big_award_draw_count = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 331 */     _xdb_verify_unsafe_();
/* 332 */     DrawCarnivalRoleActivityInfo _o_ = null;
/* 333 */     if ((_o1_ instanceof DrawCarnivalRoleActivityInfo)) { _o_ = (DrawCarnivalRoleActivityInfo)_o1_;
/* 334 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 335 */       return false;
/* 336 */     if (this.init_point_count != _o_.init_point_count) return false;
/* 337 */     if (!this.free_pass_type_id2info.equals(_o_.free_pass_type_id2info)) return false;
/* 338 */     if (this.get_next_big_award_draw_count != _o_.get_next_big_award_draw_count) return false;
/* 339 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 345 */     _xdb_verify_unsafe_();
/* 346 */     int _h_ = 0;
/* 347 */     _h_ = (int)(_h_ + this.init_point_count);
/* 348 */     _h_ += this.free_pass_type_id2info.hashCode();
/* 349 */     _h_ += this.get_next_big_award_draw_count;
/* 350 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 356 */     _xdb_verify_unsafe_();
/* 357 */     StringBuilder _sb_ = new StringBuilder();
/* 358 */     _sb_.append("(");
/* 359 */     _sb_.append(this.init_point_count);
/* 360 */     _sb_.append(",");
/* 361 */     _sb_.append(this.free_pass_type_id2info);
/* 362 */     _sb_.append(",");
/* 363 */     _sb_.append(this.get_next_big_award_draw_count);
/* 364 */     _sb_.append(")");
/* 365 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 371 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 372 */     lb.add(new xdb.logs.ListenableChanged().setVarName("init_point_count"));
/* 373 */     lb.add(new xdb.logs.ListenableMap().setVarName("free_pass_type_id2info"));
/* 374 */     lb.add(new xdb.logs.ListenableChanged().setVarName("get_next_big_award_draw_count"));
/* 375 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.DrawCarnivalRoleActivityInfo {
/*     */     private Const() {}
/*     */     
/*     */     DrawCarnivalRoleActivityInfo nThis() {
/* 382 */       return DrawCarnivalRoleActivityInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 388 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DrawCarnivalRoleActivityInfo copy()
/*     */     {
/* 394 */       return DrawCarnivalRoleActivityInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DrawCarnivalRoleActivityInfo toData()
/*     */     {
/* 400 */       return DrawCarnivalRoleActivityInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.DrawCarnivalRoleActivityInfo toBean()
/*     */     {
/* 405 */       return DrawCarnivalRoleActivityInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DrawCarnivalRoleActivityInfo toDataIf()
/*     */     {
/* 411 */       return DrawCarnivalRoleActivityInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.DrawCarnivalRoleActivityInfo toBeanIf()
/*     */     {
/* 416 */       return DrawCarnivalRoleActivityInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getInit_point_count()
/*     */     {
/* 423 */       DrawCarnivalRoleActivityInfo.this._xdb_verify_unsafe_();
/* 424 */       return DrawCarnivalRoleActivityInfo.this.init_point_count;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.DrawCarnivalRoleFreePassInfo> getFree_pass_type_id2info()
/*     */     {
/* 431 */       DrawCarnivalRoleActivityInfo.this._xdb_verify_unsafe_();
/* 432 */       return xdb.Consts.constMap(DrawCarnivalRoleActivityInfo.this.free_pass_type_id2info);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.DrawCarnivalRoleFreePassInfo> getFree_pass_type_id2infoAsData()
/*     */     {
/* 439 */       DrawCarnivalRoleActivityInfo.this._xdb_verify_unsafe_();
/*     */       
/* 441 */       DrawCarnivalRoleActivityInfo _o_ = DrawCarnivalRoleActivityInfo.this;
/* 442 */       Map<Integer, xbean.DrawCarnivalRoleFreePassInfo> free_pass_type_id2info = new HashMap();
/* 443 */       for (Map.Entry<Integer, xbean.DrawCarnivalRoleFreePassInfo> _e_ : _o_.free_pass_type_id2info.entrySet())
/* 444 */         free_pass_type_id2info.put(_e_.getKey(), new DrawCarnivalRoleFreePassInfo.Data((xbean.DrawCarnivalRoleFreePassInfo)_e_.getValue()));
/* 445 */       return free_pass_type_id2info;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getGet_next_big_award_draw_count()
/*     */     {
/* 452 */       DrawCarnivalRoleActivityInfo.this._xdb_verify_unsafe_();
/* 453 */       return DrawCarnivalRoleActivityInfo.this.get_next_big_award_draw_count;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setInit_point_count(long _v_)
/*     */     {
/* 460 */       DrawCarnivalRoleActivityInfo.this._xdb_verify_unsafe_();
/* 461 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGet_next_big_award_draw_count(int _v_)
/*     */     {
/* 468 */       DrawCarnivalRoleActivityInfo.this._xdb_verify_unsafe_();
/* 469 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 475 */       DrawCarnivalRoleActivityInfo.this._xdb_verify_unsafe_();
/* 476 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 482 */       DrawCarnivalRoleActivityInfo.this._xdb_verify_unsafe_();
/* 483 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 489 */       return DrawCarnivalRoleActivityInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 495 */       return DrawCarnivalRoleActivityInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 501 */       DrawCarnivalRoleActivityInfo.this._xdb_verify_unsafe_();
/* 502 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 508 */       return DrawCarnivalRoleActivityInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 514 */       return DrawCarnivalRoleActivityInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 520 */       DrawCarnivalRoleActivityInfo.this._xdb_verify_unsafe_();
/* 521 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 527 */       return DrawCarnivalRoleActivityInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 533 */       return DrawCarnivalRoleActivityInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 539 */       return DrawCarnivalRoleActivityInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 545 */       return DrawCarnivalRoleActivityInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 551 */       return DrawCarnivalRoleActivityInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 557 */       return DrawCarnivalRoleActivityInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 563 */       return DrawCarnivalRoleActivityInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.DrawCarnivalRoleActivityInfo
/*     */   {
/*     */     private long init_point_count;
/*     */     
/*     */     private HashMap<Integer, xbean.DrawCarnivalRoleFreePassInfo> free_pass_type_id2info;
/*     */     
/*     */     private int get_next_big_award_draw_count;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 579 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 584 */       this.free_pass_type_id2info = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.DrawCarnivalRoleActivityInfo _o1_)
/*     */     {
/* 589 */       if ((_o1_ instanceof DrawCarnivalRoleActivityInfo)) { assign((DrawCarnivalRoleActivityInfo)_o1_);
/* 590 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 591 */       } else if ((_o1_ instanceof DrawCarnivalRoleActivityInfo.Const)) assign(((DrawCarnivalRoleActivityInfo.Const)_o1_).nThis()); else {
/* 592 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(DrawCarnivalRoleActivityInfo _o_) {
/* 597 */       this.init_point_count = _o_.init_point_count;
/* 598 */       this.free_pass_type_id2info = new HashMap();
/* 599 */       for (Map.Entry<Integer, xbean.DrawCarnivalRoleFreePassInfo> _e_ : _o_.free_pass_type_id2info.entrySet())
/* 600 */         this.free_pass_type_id2info.put(_e_.getKey(), new DrawCarnivalRoleFreePassInfo.Data((xbean.DrawCarnivalRoleFreePassInfo)_e_.getValue()));
/* 601 */       this.get_next_big_award_draw_count = _o_.get_next_big_award_draw_count;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 606 */       this.init_point_count = _o_.init_point_count;
/* 607 */       this.free_pass_type_id2info = new HashMap();
/* 608 */       for (Map.Entry<Integer, xbean.DrawCarnivalRoleFreePassInfo> _e_ : _o_.free_pass_type_id2info.entrySet())
/* 609 */         this.free_pass_type_id2info.put(_e_.getKey(), new DrawCarnivalRoleFreePassInfo.Data((xbean.DrawCarnivalRoleFreePassInfo)_e_.getValue()));
/* 610 */       this.get_next_big_award_draw_count = _o_.get_next_big_award_draw_count;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 616 */       _os_.marshal(this.init_point_count);
/* 617 */       _os_.compact_uint32(this.free_pass_type_id2info.size());
/* 618 */       for (Map.Entry<Integer, xbean.DrawCarnivalRoleFreePassInfo> _e_ : this.free_pass_type_id2info.entrySet())
/*     */       {
/* 620 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 621 */         ((xbean.DrawCarnivalRoleFreePassInfo)_e_.getValue()).marshal(_os_);
/*     */       }
/* 623 */       _os_.marshal(this.get_next_big_award_draw_count);
/* 624 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 630 */       this.init_point_count = _os_.unmarshal_long();
/*     */       
/* 632 */       int size = _os_.uncompact_uint32();
/* 633 */       if (size >= 12)
/*     */       {
/* 635 */         this.free_pass_type_id2info = new HashMap(size * 2);
/*     */       }
/* 637 */       for (; size > 0; size--)
/*     */       {
/* 639 */         int _k_ = 0;
/* 640 */         _k_ = _os_.unmarshal_int();
/* 641 */         xbean.DrawCarnivalRoleFreePassInfo _v_ = xbean.Pod.newDrawCarnivalRoleFreePassInfoData();
/* 642 */         _v_.unmarshal(_os_);
/* 643 */         this.free_pass_type_id2info.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 646 */       this.get_next_big_award_draw_count = _os_.unmarshal_int();
/* 647 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 653 */       int _size_ = 0;
/* 654 */       _size_ += CodedOutputStream.computeInt64Size(1, this.init_point_count);
/* 655 */       for (Map.Entry<Integer, xbean.DrawCarnivalRoleFreePassInfo> _e_ : this.free_pass_type_id2info.entrySet())
/*     */       {
/* 657 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/* 658 */         _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*     */       }
/* 660 */       _size_ += CodedOutputStream.computeInt32Size(3, this.get_next_big_award_draw_count);
/* 661 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 669 */         _output_.writeInt64(1, this.init_point_count);
/* 670 */         for (Map.Entry<Integer, xbean.DrawCarnivalRoleFreePassInfo> _e_ : this.free_pass_type_id2info.entrySet())
/*     */         {
/* 672 */           _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/* 673 */           _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*     */         }
/* 675 */         _output_.writeInt32(3, this.get_next_big_award_draw_count);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 679 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 681 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 689 */         boolean done = false;
/* 690 */         while (!done)
/*     */         {
/* 692 */           int tag = _input_.readTag();
/* 693 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 697 */             done = true;
/* 698 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 702 */             this.init_point_count = _input_.readInt64();
/* 703 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 707 */             int _k_ = 0;
/* 708 */             _k_ = _input_.readInt32();
/* 709 */             int readTag = _input_.readTag();
/* 710 */             if (18 != readTag)
/*     */             {
/* 712 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 714 */             xbean.DrawCarnivalRoleFreePassInfo _v_ = xbean.Pod.newDrawCarnivalRoleFreePassInfoData();
/* 715 */             _input_.readMessage(_v_);
/* 716 */             this.free_pass_type_id2info.put(Integer.valueOf(_k_), _v_);
/* 717 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 721 */             this.get_next_big_award_draw_count = _input_.readInt32();
/* 722 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 726 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 728 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 737 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 741 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 743 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DrawCarnivalRoleActivityInfo copy()
/*     */     {
/* 749 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DrawCarnivalRoleActivityInfo toData()
/*     */     {
/* 755 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.DrawCarnivalRoleActivityInfo toBean()
/*     */     {
/* 760 */       return new DrawCarnivalRoleActivityInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DrawCarnivalRoleActivityInfo toDataIf()
/*     */     {
/* 766 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.DrawCarnivalRoleActivityInfo toBeanIf()
/*     */     {
/* 771 */       return new DrawCarnivalRoleActivityInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 777 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 781 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 785 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 789 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 793 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 797 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 801 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getInit_point_count()
/*     */     {
/* 808 */       return this.init_point_count;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.DrawCarnivalRoleFreePassInfo> getFree_pass_type_id2info()
/*     */     {
/* 815 */       return this.free_pass_type_id2info;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.DrawCarnivalRoleFreePassInfo> getFree_pass_type_id2infoAsData()
/*     */     {
/* 822 */       return this.free_pass_type_id2info;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getGet_next_big_award_draw_count()
/*     */     {
/* 829 */       return this.get_next_big_award_draw_count;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setInit_point_count(long _v_)
/*     */     {
/* 836 */       this.init_point_count = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGet_next_big_award_draw_count(int _v_)
/*     */     {
/* 843 */       this.get_next_big_award_draw_count = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 849 */       if (!(_o1_ instanceof Data)) return false;
/* 850 */       Data _o_ = (Data)_o1_;
/* 851 */       if (this.init_point_count != _o_.init_point_count) return false;
/* 852 */       if (!this.free_pass_type_id2info.equals(_o_.free_pass_type_id2info)) return false;
/* 853 */       if (this.get_next_big_award_draw_count != _o_.get_next_big_award_draw_count) return false;
/* 854 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 860 */       int _h_ = 0;
/* 861 */       _h_ = (int)(_h_ + this.init_point_count);
/* 862 */       _h_ += this.free_pass_type_id2info.hashCode();
/* 863 */       _h_ += this.get_next_big_award_draw_count;
/* 864 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 870 */       StringBuilder _sb_ = new StringBuilder();
/* 871 */       _sb_.append("(");
/* 872 */       _sb_.append(this.init_point_count);
/* 873 */       _sb_.append(",");
/* 874 */       _sb_.append(this.free_pass_type_id2info);
/* 875 */       _sb_.append(",");
/* 876 */       _sb_.append(this.get_next_big_award_draw_count);
/* 877 */       _sb_.append(")");
/* 878 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\DrawCarnivalRoleActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */