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
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class GangRaceRoleInfo extends XBean implements xbean.GangRaceRoleInfo
/*     */ {
/*     */   private int gameid;
/*     */   private HashMap<Integer, Integer> raceid2money;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.gameid = 0;
/*  21 */     this.raceid2money.clear();
/*     */   }
/*     */   
/*     */   GangRaceRoleInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.raceid2money = new HashMap();
/*     */   }
/*     */   
/*     */   public GangRaceRoleInfo()
/*     */   {
/*  32 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public GangRaceRoleInfo(GangRaceRoleInfo _o_)
/*     */   {
/*  37 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   GangRaceRoleInfo(xbean.GangRaceRoleInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  42 */     super(_xp_, _vn_);
/*  43 */     if ((_o1_ instanceof GangRaceRoleInfo)) { assign((GangRaceRoleInfo)_o1_);
/*  44 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  45 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  46 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(GangRaceRoleInfo _o_) {
/*  51 */     _o_._xdb_verify_unsafe_();
/*  52 */     this.gameid = _o_.gameid;
/*  53 */     this.raceid2money = new HashMap();
/*  54 */     for (Map.Entry<Integer, Integer> _e_ : _o_.raceid2money.entrySet()) {
/*  55 */       this.raceid2money.put(_e_.getKey(), _e_.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  60 */     this.gameid = _o_.gameid;
/*  61 */     this.raceid2money = new HashMap();
/*  62 */     for (Map.Entry<Integer, Integer> _e_ : _o_.raceid2money.entrySet()) {
/*  63 */       this.raceid2money.put(_e_.getKey(), _e_.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  69 */     _xdb_verify_unsafe_();
/*  70 */     _os_.marshal(this.gameid);
/*  71 */     _os_.compact_uint32(this.raceid2money.size());
/*  72 */     for (Map.Entry<Integer, Integer> _e_ : this.raceid2money.entrySet())
/*     */     {
/*  74 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  75 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  83 */     _xdb_verify_unsafe_();
/*  84 */     this.gameid = _os_.unmarshal_int();
/*     */     
/*  86 */     int size = _os_.uncompact_uint32();
/*  87 */     if (size >= 12)
/*     */     {
/*  89 */       this.raceid2money = new HashMap(size * 2);
/*     */     }
/*  91 */     for (; size > 0; size--)
/*     */     {
/*  93 */       int _k_ = 0;
/*  94 */       _k_ = _os_.unmarshal_int();
/*  95 */       int _v_ = 0;
/*  96 */       _v_ = _os_.unmarshal_int();
/*  97 */       this.raceid2money.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*     */     
/* 100 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 106 */     _xdb_verify_unsafe_();
/* 107 */     int _size_ = 0;
/* 108 */     _size_ += CodedOutputStream.computeInt32Size(1, this.gameid);
/* 109 */     for (Map.Entry<Integer, Integer> _e_ : this.raceid2money.entrySet())
/*     */     {
/* 111 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/* 112 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getValue()).intValue());
/*     */     }
/* 114 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 120 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 123 */       _output_.writeInt32(1, this.gameid);
/* 124 */       for (Map.Entry<Integer, Integer> _e_ : this.raceid2money.entrySet())
/*     */       {
/* 126 */         _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/* 127 */         _output_.writeInt32(2, ((Integer)_e_.getValue()).intValue());
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 132 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 134 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 140 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 143 */       boolean done = false;
/* 144 */       while (!done)
/*     */       {
/* 146 */         int tag = _input_.readTag();
/* 147 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 151 */           done = true;
/* 152 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 156 */           this.gameid = _input_.readInt32();
/* 157 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 161 */           int _k_ = 0;
/* 162 */           _k_ = _input_.readInt32();
/* 163 */           int readTag = _input_.readTag();
/* 164 */           if (16 != readTag)
/*     */           {
/* 166 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 168 */           int _v_ = 0;
/* 169 */           _v_ = _input_.readInt32();
/* 170 */           this.raceid2money.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 171 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 175 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 177 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 186 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 190 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 192 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GangRaceRoleInfo copy()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return new GangRaceRoleInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GangRaceRoleInfo toData()
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.GangRaceRoleInfo toBean()
/*     */   {
/* 211 */     _xdb_verify_unsafe_();
/* 212 */     return new GangRaceRoleInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GangRaceRoleInfo toDataIf()
/*     */   {
/* 218 */     _xdb_verify_unsafe_();
/* 219 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.GangRaceRoleInfo toBeanIf()
/*     */   {
/* 224 */     _xdb_verify_unsafe_();
/* 225 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 231 */     _xdb_verify_unsafe_();
/* 232 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getGameid()
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     return this.gameid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getRaceid2money()
/*     */   {
/* 247 */     _xdb_verify_unsafe_();
/* 248 */     return xdb.Logs.logMap(new xdb.LogKey(this, "raceid2money"), this.raceid2money);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getRaceid2moneyAsData()
/*     */   {
/* 255 */     _xdb_verify_unsafe_();
/*     */     
/* 257 */     GangRaceRoleInfo _o_ = this;
/* 258 */     Map<Integer, Integer> raceid2money = new HashMap();
/* 259 */     for (Map.Entry<Integer, Integer> _e_ : _o_.raceid2money.entrySet())
/* 260 */       raceid2money.put(_e_.getKey(), _e_.getValue());
/* 261 */     return raceid2money;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setGameid(int _v_)
/*     */   {
/* 268 */     _xdb_verify_unsafe_();
/* 269 */     xdb.Logs.logIf(new xdb.LogKey(this, "gameid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 273 */         new xdb.logs.LogInt(this, GangRaceRoleInfo.this.gameid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 277 */             GangRaceRoleInfo.this.gameid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 281 */     });
/* 282 */     this.gameid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 288 */     _xdb_verify_unsafe_();
/* 289 */     GangRaceRoleInfo _o_ = null;
/* 290 */     if ((_o1_ instanceof GangRaceRoleInfo)) { _o_ = (GangRaceRoleInfo)_o1_;
/* 291 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 292 */       return false;
/* 293 */     if (this.gameid != _o_.gameid) return false;
/* 294 */     if (!this.raceid2money.equals(_o_.raceid2money)) return false;
/* 295 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/* 302 */     int _h_ = 0;
/* 303 */     _h_ += this.gameid;
/* 304 */     _h_ += this.raceid2money.hashCode();
/* 305 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 311 */     _xdb_verify_unsafe_();
/* 312 */     StringBuilder _sb_ = new StringBuilder();
/* 313 */     _sb_.append("(");
/* 314 */     _sb_.append(this.gameid);
/* 315 */     _sb_.append(",");
/* 316 */     _sb_.append(this.raceid2money);
/* 317 */     _sb_.append(")");
/* 318 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 324 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 325 */     lb.add(new xdb.logs.ListenableChanged().setVarName("gameid"));
/* 326 */     lb.add(new xdb.logs.ListenableMap().setVarName("raceid2money"));
/* 327 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.GangRaceRoleInfo {
/*     */     private Const() {}
/*     */     
/*     */     GangRaceRoleInfo nThis() {
/* 334 */       return GangRaceRoleInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 340 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GangRaceRoleInfo copy()
/*     */     {
/* 346 */       return GangRaceRoleInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GangRaceRoleInfo toData()
/*     */     {
/* 352 */       return GangRaceRoleInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.GangRaceRoleInfo toBean()
/*     */     {
/* 357 */       return GangRaceRoleInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GangRaceRoleInfo toDataIf()
/*     */     {
/* 363 */       return GangRaceRoleInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.GangRaceRoleInfo toBeanIf()
/*     */     {
/* 368 */       return GangRaceRoleInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getGameid()
/*     */     {
/* 375 */       GangRaceRoleInfo.this._xdb_verify_unsafe_();
/* 376 */       return GangRaceRoleInfo.this.gameid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getRaceid2money()
/*     */     {
/* 383 */       GangRaceRoleInfo.this._xdb_verify_unsafe_();
/* 384 */       return xdb.Consts.constMap(GangRaceRoleInfo.this.raceid2money);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getRaceid2moneyAsData()
/*     */     {
/* 391 */       GangRaceRoleInfo.this._xdb_verify_unsafe_();
/*     */       
/* 393 */       GangRaceRoleInfo _o_ = GangRaceRoleInfo.this;
/* 394 */       Map<Integer, Integer> raceid2money = new HashMap();
/* 395 */       for (Map.Entry<Integer, Integer> _e_ : _o_.raceid2money.entrySet())
/* 396 */         raceid2money.put(_e_.getKey(), _e_.getValue());
/* 397 */       return raceid2money;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGameid(int _v_)
/*     */     {
/* 404 */       GangRaceRoleInfo.this._xdb_verify_unsafe_();
/* 405 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 411 */       GangRaceRoleInfo.this._xdb_verify_unsafe_();
/* 412 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 418 */       GangRaceRoleInfo.this._xdb_verify_unsafe_();
/* 419 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 425 */       return GangRaceRoleInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 431 */       return GangRaceRoleInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 437 */       GangRaceRoleInfo.this._xdb_verify_unsafe_();
/* 438 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 444 */       return GangRaceRoleInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 450 */       return GangRaceRoleInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 456 */       GangRaceRoleInfo.this._xdb_verify_unsafe_();
/* 457 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 463 */       return GangRaceRoleInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 469 */       return GangRaceRoleInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 475 */       return GangRaceRoleInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 481 */       return GangRaceRoleInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 487 */       return GangRaceRoleInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 493 */       return GangRaceRoleInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 499 */       return GangRaceRoleInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.GangRaceRoleInfo
/*     */   {
/*     */     private int gameid;
/*     */     
/*     */     private HashMap<Integer, Integer> raceid2money;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 513 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 518 */       this.raceid2money = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.GangRaceRoleInfo _o1_)
/*     */     {
/* 523 */       if ((_o1_ instanceof GangRaceRoleInfo)) { assign((GangRaceRoleInfo)_o1_);
/* 524 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 525 */       } else if ((_o1_ instanceof GangRaceRoleInfo.Const)) assign(((GangRaceRoleInfo.Const)_o1_).nThis()); else {
/* 526 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(GangRaceRoleInfo _o_) {
/* 531 */       this.gameid = _o_.gameid;
/* 532 */       this.raceid2money = new HashMap();
/* 533 */       for (Map.Entry<Integer, Integer> _e_ : _o_.raceid2money.entrySet()) {
/* 534 */         this.raceid2money.put(_e_.getKey(), _e_.getValue());
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 539 */       this.gameid = _o_.gameid;
/* 540 */       this.raceid2money = new HashMap();
/* 541 */       for (Map.Entry<Integer, Integer> _e_ : _o_.raceid2money.entrySet()) {
/* 542 */         this.raceid2money.put(_e_.getKey(), _e_.getValue());
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 548 */       _os_.marshal(this.gameid);
/* 549 */       _os_.compact_uint32(this.raceid2money.size());
/* 550 */       for (Map.Entry<Integer, Integer> _e_ : this.raceid2money.entrySet())
/*     */       {
/* 552 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 553 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */       }
/* 555 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 561 */       this.gameid = _os_.unmarshal_int();
/*     */       
/* 563 */       int size = _os_.uncompact_uint32();
/* 564 */       if (size >= 12)
/*     */       {
/* 566 */         this.raceid2money = new HashMap(size * 2);
/*     */       }
/* 568 */       for (; size > 0; size--)
/*     */       {
/* 570 */         int _k_ = 0;
/* 571 */         _k_ = _os_.unmarshal_int();
/* 572 */         int _v_ = 0;
/* 573 */         _v_ = _os_.unmarshal_int();
/* 574 */         this.raceid2money.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */       
/* 577 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 583 */       int _size_ = 0;
/* 584 */       _size_ += CodedOutputStream.computeInt32Size(1, this.gameid);
/* 585 */       for (Map.Entry<Integer, Integer> _e_ : this.raceid2money.entrySet())
/*     */       {
/* 587 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/* 588 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 590 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 598 */         _output_.writeInt32(1, this.gameid);
/* 599 */         for (Map.Entry<Integer, Integer> _e_ : this.raceid2money.entrySet())
/*     */         {
/* 601 */           _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/* 602 */           _output_.writeInt32(2, ((Integer)_e_.getValue()).intValue());
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 607 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 609 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 617 */         boolean done = false;
/* 618 */         while (!done)
/*     */         {
/* 620 */           int tag = _input_.readTag();
/* 621 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 625 */             done = true;
/* 626 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 630 */             this.gameid = _input_.readInt32();
/* 631 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 635 */             int _k_ = 0;
/* 636 */             _k_ = _input_.readInt32();
/* 637 */             int readTag = _input_.readTag();
/* 638 */             if (16 != readTag)
/*     */             {
/* 640 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 642 */             int _v_ = 0;
/* 643 */             _v_ = _input_.readInt32();
/* 644 */             this.raceid2money.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 645 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 649 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 651 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 660 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 664 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 666 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GangRaceRoleInfo copy()
/*     */     {
/* 672 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GangRaceRoleInfo toData()
/*     */     {
/* 678 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.GangRaceRoleInfo toBean()
/*     */     {
/* 683 */       return new GangRaceRoleInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GangRaceRoleInfo toDataIf()
/*     */     {
/* 689 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.GangRaceRoleInfo toBeanIf()
/*     */     {
/* 694 */       return new GangRaceRoleInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 700 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 704 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 708 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 712 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 716 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 720 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 724 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getGameid()
/*     */     {
/* 731 */       return this.gameid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getRaceid2money()
/*     */     {
/* 738 */       return this.raceid2money;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getRaceid2moneyAsData()
/*     */     {
/* 745 */       return this.raceid2money;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGameid(int _v_)
/*     */     {
/* 752 */       this.gameid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 758 */       if (!(_o1_ instanceof Data)) return false;
/* 759 */       Data _o_ = (Data)_o1_;
/* 760 */       if (this.gameid != _o_.gameid) return false;
/* 761 */       if (!this.raceid2money.equals(_o_.raceid2money)) return false;
/* 762 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 768 */       int _h_ = 0;
/* 769 */       _h_ += this.gameid;
/* 770 */       _h_ += this.raceid2money.hashCode();
/* 771 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 777 */       StringBuilder _sb_ = new StringBuilder();
/* 778 */       _sb_.append("(");
/* 779 */       _sb_.append(this.gameid);
/* 780 */       _sb_.append(",");
/* 781 */       _sb_.append(this.raceid2money);
/* 782 */       _sb_.append(")");
/* 783 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\GangRaceRoleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */