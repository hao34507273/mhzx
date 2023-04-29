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
/*     */ import xdb.logs.ListenableBean;
/*     */ 
/*     */ public final class RoleGrabData extends XBean implements xbean.RoleGrabData
/*     */ {
/*     */   private HashMap<Integer, Integer> ownpositions;
/*     */   private xbean.RoleGrabSessions sessiondata;
/*     */   private int point;
/*     */   private int grabpositionid;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.ownpositions.clear();
/*  25 */     this.sessiondata._reset_unsafe_();
/*  26 */     this.point = 0;
/*  27 */     this.grabpositionid = 0;
/*     */   }
/*     */   
/*     */   RoleGrabData(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*  33 */     this.ownpositions = new HashMap();
/*  34 */     this.sessiondata = new RoleGrabSessions(0, this, "sessiondata");
/*     */   }
/*     */   
/*     */   public RoleGrabData()
/*     */   {
/*  39 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public RoleGrabData(RoleGrabData _o_)
/*     */   {
/*  44 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   RoleGrabData(xbean.RoleGrabData _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  49 */     super(_xp_, _vn_);
/*  50 */     if ((_o1_ instanceof RoleGrabData)) { assign((RoleGrabData)_o1_);
/*  51 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  52 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  53 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(RoleGrabData _o_) {
/*  58 */     _o_._xdb_verify_unsafe_();
/*  59 */     this.ownpositions = new HashMap();
/*  60 */     for (Map.Entry<Integer, Integer> _e_ : _o_.ownpositions.entrySet())
/*  61 */       this.ownpositions.put(_e_.getKey(), _e_.getValue());
/*  62 */     this.sessiondata = new RoleGrabSessions(_o_.sessiondata, this, "sessiondata");
/*  63 */     this.point = _o_.point;
/*  64 */     this.grabpositionid = _o_.grabpositionid;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  69 */     this.ownpositions = new HashMap();
/*  70 */     for (Map.Entry<Integer, Integer> _e_ : _o_.ownpositions.entrySet())
/*  71 */       this.ownpositions.put(_e_.getKey(), _e_.getValue());
/*  72 */     this.sessiondata = new RoleGrabSessions(_o_.sessiondata, this, "sessiondata");
/*  73 */     this.point = _o_.point;
/*  74 */     this.grabpositionid = _o_.grabpositionid;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  80 */     _xdb_verify_unsafe_();
/*  81 */     _os_.compact_uint32(this.ownpositions.size());
/*  82 */     for (Map.Entry<Integer, Integer> _e_ : this.ownpositions.entrySet())
/*     */     {
/*  84 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  85 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  87 */     this.sessiondata.marshal(_os_);
/*  88 */     _os_.marshal(this.point);
/*  89 */     _os_.marshal(this.grabpositionid);
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  96 */     _xdb_verify_unsafe_();
/*     */     
/*  98 */     int size = _os_.uncompact_uint32();
/*  99 */     if (size >= 12)
/*     */     {
/* 101 */       this.ownpositions = new HashMap(size * 2);
/*     */     }
/* 103 */     for (; size > 0; size--)
/*     */     {
/* 105 */       int _k_ = 0;
/* 106 */       _k_ = _os_.unmarshal_int();
/* 107 */       int _v_ = 0;
/* 108 */       _v_ = _os_.unmarshal_int();
/* 109 */       this.ownpositions.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*     */     
/* 112 */     this.sessiondata.unmarshal(_os_);
/* 113 */     this.point = _os_.unmarshal_int();
/* 114 */     this.grabpositionid = _os_.unmarshal_int();
/* 115 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 121 */     _xdb_verify_unsafe_();
/* 122 */     int _size_ = 0;
/* 123 */     for (Map.Entry<Integer, Integer> _e_ : this.ownpositions.entrySet())
/*     */     {
/* 125 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 126 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getValue()).intValue());
/*     */     }
/* 128 */     _size_ += CodedOutputStream.computeMessageSize(2, this.sessiondata);
/* 129 */     _size_ += CodedOutputStream.computeInt32Size(3, this.point);
/* 130 */     _size_ += CodedOutputStream.computeInt32Size(4, this.grabpositionid);
/* 131 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 137 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 140 */       for (Map.Entry<Integer, Integer> _e_ : this.ownpositions.entrySet())
/*     */       {
/* 142 */         _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 143 */         _output_.writeInt32(1, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 145 */       _output_.writeMessage(2, this.sessiondata);
/* 146 */       _output_.writeInt32(3, this.point);
/* 147 */       _output_.writeInt32(4, this.grabpositionid);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 151 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 153 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 159 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 162 */       boolean done = false;
/* 163 */       while (!done)
/*     */       {
/* 165 */         int tag = _input_.readTag();
/* 166 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 170 */           done = true;
/* 171 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 175 */           int _k_ = 0;
/* 176 */           _k_ = _input_.readInt32();
/* 177 */           int readTag = _input_.readTag();
/* 178 */           if (8 != readTag)
/*     */           {
/* 180 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 182 */           int _v_ = 0;
/* 183 */           _v_ = _input_.readInt32();
/* 184 */           this.ownpositions.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 185 */           break;
/*     */         
/*     */ 
/*     */         case 18: 
/* 189 */           _input_.readMessage(this.sessiondata);
/* 190 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 194 */           this.point = _input_.readInt32();
/* 195 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 199 */           this.grabpositionid = _input_.readInt32();
/* 200 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 204 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 206 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 215 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 219 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 221 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleGrabData copy()
/*     */   {
/* 227 */     _xdb_verify_unsafe_();
/* 228 */     return new RoleGrabData(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleGrabData toData()
/*     */   {
/* 234 */     _xdb_verify_unsafe_();
/* 235 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleGrabData toBean()
/*     */   {
/* 240 */     _xdb_verify_unsafe_();
/* 241 */     return new RoleGrabData(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleGrabData toDataIf()
/*     */   {
/* 247 */     _xdb_verify_unsafe_();
/* 248 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleGrabData toBeanIf()
/*     */   {
/* 253 */     _xdb_verify_unsafe_();
/* 254 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 260 */     _xdb_verify_unsafe_();
/* 261 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getOwnpositions()
/*     */   {
/* 268 */     _xdb_verify_unsafe_();
/* 269 */     return xdb.Logs.logMap(new LogKey(this, "ownpositions"), this.ownpositions);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getOwnpositionsAsData()
/*     */   {
/* 276 */     _xdb_verify_unsafe_();
/*     */     
/* 278 */     RoleGrabData _o_ = this;
/* 279 */     Map<Integer, Integer> ownpositions = new HashMap();
/* 280 */     for (Map.Entry<Integer, Integer> _e_ : _o_.ownpositions.entrySet())
/* 281 */       ownpositions.put(_e_.getKey(), _e_.getValue());
/* 282 */     return ownpositions;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public xbean.RoleGrabSessions getSessiondata()
/*     */   {
/* 289 */     _xdb_verify_unsafe_();
/* 290 */     return this.sessiondata;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getPoint()
/*     */   {
/* 297 */     _xdb_verify_unsafe_();
/* 298 */     return this.point;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getGrabpositionid()
/*     */   {
/* 305 */     _xdb_verify_unsafe_();
/* 306 */     return this.grabpositionid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPoint(int _v_)
/*     */   {
/* 313 */     _xdb_verify_unsafe_();
/* 314 */     xdb.Logs.logIf(new LogKey(this, "point")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 318 */         new xdb.logs.LogInt(this, RoleGrabData.this.point)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 322 */             RoleGrabData.this.point = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 326 */     });
/* 327 */     this.point = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setGrabpositionid(int _v_)
/*     */   {
/* 334 */     _xdb_verify_unsafe_();
/* 335 */     xdb.Logs.logIf(new LogKey(this, "grabpositionid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 339 */         new xdb.logs.LogInt(this, RoleGrabData.this.grabpositionid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 343 */             RoleGrabData.this.grabpositionid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 347 */     });
/* 348 */     this.grabpositionid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 354 */     _xdb_verify_unsafe_();
/* 355 */     RoleGrabData _o_ = null;
/* 356 */     if ((_o1_ instanceof RoleGrabData)) { _o_ = (RoleGrabData)_o1_;
/* 357 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 358 */       return false;
/* 359 */     if (!this.ownpositions.equals(_o_.ownpositions)) return false;
/* 360 */     if (!this.sessiondata.equals(_o_.sessiondata)) return false;
/* 361 */     if (this.point != _o_.point) return false;
/* 362 */     if (this.grabpositionid != _o_.grabpositionid) return false;
/* 363 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 369 */     _xdb_verify_unsafe_();
/* 370 */     int _h_ = 0;
/* 371 */     _h_ += this.ownpositions.hashCode();
/* 372 */     _h_ += this.sessiondata.hashCode();
/* 373 */     _h_ += this.point;
/* 374 */     _h_ += this.grabpositionid;
/* 375 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 381 */     _xdb_verify_unsafe_();
/* 382 */     StringBuilder _sb_ = new StringBuilder();
/* 383 */     _sb_.append("(");
/* 384 */     _sb_.append(this.ownpositions);
/* 385 */     _sb_.append(",");
/* 386 */     _sb_.append(this.sessiondata);
/* 387 */     _sb_.append(",");
/* 388 */     _sb_.append(this.point);
/* 389 */     _sb_.append(",");
/* 390 */     _sb_.append(this.grabpositionid);
/* 391 */     _sb_.append(")");
/* 392 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 398 */     ListenableBean lb = new ListenableBean();
/* 399 */     lb.add(new xdb.logs.ListenableMap().setVarName("ownpositions"));
/* 400 */     lb.add(new xdb.logs.ListenableChanged().setVarName("sessiondata"));
/* 401 */     lb.add(new xdb.logs.ListenableChanged().setVarName("point"));
/* 402 */     lb.add(new xdb.logs.ListenableChanged().setVarName("grabpositionid"));
/* 403 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.RoleGrabData {
/*     */     private Const() {}
/*     */     
/*     */     RoleGrabData nThis() {
/* 410 */       return RoleGrabData.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 416 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleGrabData copy()
/*     */     {
/* 422 */       return RoleGrabData.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleGrabData toData()
/*     */     {
/* 428 */       return RoleGrabData.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.RoleGrabData toBean()
/*     */     {
/* 433 */       return RoleGrabData.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleGrabData toDataIf()
/*     */     {
/* 439 */       return RoleGrabData.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.RoleGrabData toBeanIf()
/*     */     {
/* 444 */       return RoleGrabData.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getOwnpositions()
/*     */     {
/* 451 */       RoleGrabData.this._xdb_verify_unsafe_();
/* 452 */       return xdb.Consts.constMap(RoleGrabData.this.ownpositions);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getOwnpositionsAsData()
/*     */     {
/* 459 */       RoleGrabData.this._xdb_verify_unsafe_();
/*     */       
/* 461 */       RoleGrabData _o_ = RoleGrabData.this;
/* 462 */       Map<Integer, Integer> ownpositions = new HashMap();
/* 463 */       for (Map.Entry<Integer, Integer> _e_ : _o_.ownpositions.entrySet())
/* 464 */         ownpositions.put(_e_.getKey(), _e_.getValue());
/* 465 */       return ownpositions;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public xbean.RoleGrabSessions getSessiondata()
/*     */     {
/* 472 */       RoleGrabData.this._xdb_verify_unsafe_();
/* 473 */       return (xbean.RoleGrabSessions)xdb.Consts.toConst(RoleGrabData.this.sessiondata);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getPoint()
/*     */     {
/* 480 */       RoleGrabData.this._xdb_verify_unsafe_();
/* 481 */       return RoleGrabData.this.point;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getGrabpositionid()
/*     */     {
/* 488 */       RoleGrabData.this._xdb_verify_unsafe_();
/* 489 */       return RoleGrabData.this.grabpositionid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPoint(int _v_)
/*     */     {
/* 496 */       RoleGrabData.this._xdb_verify_unsafe_();
/* 497 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGrabpositionid(int _v_)
/*     */     {
/* 504 */       RoleGrabData.this._xdb_verify_unsafe_();
/* 505 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 511 */       RoleGrabData.this._xdb_verify_unsafe_();
/* 512 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 518 */       RoleGrabData.this._xdb_verify_unsafe_();
/* 519 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 525 */       return RoleGrabData.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 531 */       return RoleGrabData.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 537 */       RoleGrabData.this._xdb_verify_unsafe_();
/* 538 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 544 */       return RoleGrabData.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 550 */       return RoleGrabData.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 556 */       RoleGrabData.this._xdb_verify_unsafe_();
/* 557 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 563 */       return RoleGrabData.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 569 */       return RoleGrabData.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 575 */       return RoleGrabData.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 581 */       return RoleGrabData.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 587 */       return RoleGrabData.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 593 */       return RoleGrabData.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 599 */       return RoleGrabData.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.RoleGrabData
/*     */   {
/*     */     private HashMap<Integer, Integer> ownpositions;
/*     */     
/*     */     private xbean.RoleGrabSessions sessiondata;
/*     */     
/*     */     private int point;
/*     */     
/*     */     private int grabpositionid;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 617 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 622 */       this.ownpositions = new HashMap();
/* 623 */       this.sessiondata = new RoleGrabSessions.Data();
/*     */     }
/*     */     
/*     */     Data(xbean.RoleGrabData _o1_)
/*     */     {
/* 628 */       if ((_o1_ instanceof RoleGrabData)) { assign((RoleGrabData)_o1_);
/* 629 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 630 */       } else if ((_o1_ instanceof RoleGrabData.Const)) assign(((RoleGrabData.Const)_o1_).nThis()); else {
/* 631 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(RoleGrabData _o_) {
/* 636 */       this.ownpositions = new HashMap();
/* 637 */       for (Map.Entry<Integer, Integer> _e_ : _o_.ownpositions.entrySet())
/* 638 */         this.ownpositions.put(_e_.getKey(), _e_.getValue());
/* 639 */       this.sessiondata = new RoleGrabSessions.Data(_o_.sessiondata);
/* 640 */       this.point = _o_.point;
/* 641 */       this.grabpositionid = _o_.grabpositionid;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 646 */       this.ownpositions = new HashMap();
/* 647 */       for (Map.Entry<Integer, Integer> _e_ : _o_.ownpositions.entrySet())
/* 648 */         this.ownpositions.put(_e_.getKey(), _e_.getValue());
/* 649 */       this.sessiondata = new RoleGrabSessions.Data(_o_.sessiondata);
/* 650 */       this.point = _o_.point;
/* 651 */       this.grabpositionid = _o_.grabpositionid;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 657 */       _os_.compact_uint32(this.ownpositions.size());
/* 658 */       for (Map.Entry<Integer, Integer> _e_ : this.ownpositions.entrySet())
/*     */       {
/* 660 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 661 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */       }
/* 663 */       this.sessiondata.marshal(_os_);
/* 664 */       _os_.marshal(this.point);
/* 665 */       _os_.marshal(this.grabpositionid);
/* 666 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 673 */       int size = _os_.uncompact_uint32();
/* 674 */       if (size >= 12)
/*     */       {
/* 676 */         this.ownpositions = new HashMap(size * 2);
/*     */       }
/* 678 */       for (; size > 0; size--)
/*     */       {
/* 680 */         int _k_ = 0;
/* 681 */         _k_ = _os_.unmarshal_int();
/* 682 */         int _v_ = 0;
/* 683 */         _v_ = _os_.unmarshal_int();
/* 684 */         this.ownpositions.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */       
/* 687 */       this.sessiondata.unmarshal(_os_);
/* 688 */       this.point = _os_.unmarshal_int();
/* 689 */       this.grabpositionid = _os_.unmarshal_int();
/* 690 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 696 */       int _size_ = 0;
/* 697 */       for (Map.Entry<Integer, Integer> _e_ : this.ownpositions.entrySet())
/*     */       {
/* 699 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 700 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 702 */       _size_ += CodedOutputStream.computeMessageSize(2, this.sessiondata);
/* 703 */       _size_ += CodedOutputStream.computeInt32Size(3, this.point);
/* 704 */       _size_ += CodedOutputStream.computeInt32Size(4, this.grabpositionid);
/* 705 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 713 */         for (Map.Entry<Integer, Integer> _e_ : this.ownpositions.entrySet())
/*     */         {
/* 715 */           _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 716 */           _output_.writeInt32(1, ((Integer)_e_.getValue()).intValue());
/*     */         }
/* 718 */         _output_.writeMessage(2, this.sessiondata);
/* 719 */         _output_.writeInt32(3, this.point);
/* 720 */         _output_.writeInt32(4, this.grabpositionid);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 724 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 726 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 734 */         boolean done = false;
/* 735 */         while (!done)
/*     */         {
/* 737 */           int tag = _input_.readTag();
/* 738 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 742 */             done = true;
/* 743 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 747 */             int _k_ = 0;
/* 748 */             _k_ = _input_.readInt32();
/* 749 */             int readTag = _input_.readTag();
/* 750 */             if (8 != readTag)
/*     */             {
/* 752 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 754 */             int _v_ = 0;
/* 755 */             _v_ = _input_.readInt32();
/* 756 */             this.ownpositions.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 757 */             break;
/*     */           
/*     */ 
/*     */           case 18: 
/* 761 */             _input_.readMessage(this.sessiondata);
/* 762 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 766 */             this.point = _input_.readInt32();
/* 767 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 771 */             this.grabpositionid = _input_.readInt32();
/* 772 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 776 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 778 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 787 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 791 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 793 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleGrabData copy()
/*     */     {
/* 799 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleGrabData toData()
/*     */     {
/* 805 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.RoleGrabData toBean()
/*     */     {
/* 810 */       return new RoleGrabData(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleGrabData toDataIf()
/*     */     {
/* 816 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.RoleGrabData toBeanIf()
/*     */     {
/* 821 */       return new RoleGrabData(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 827 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 831 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 835 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 839 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 843 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 847 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 851 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getOwnpositions()
/*     */     {
/* 858 */       return this.ownpositions;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getOwnpositionsAsData()
/*     */     {
/* 865 */       return this.ownpositions;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public xbean.RoleGrabSessions getSessiondata()
/*     */     {
/* 872 */       return this.sessiondata;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getPoint()
/*     */     {
/* 879 */       return this.point;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getGrabpositionid()
/*     */     {
/* 886 */       return this.grabpositionid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPoint(int _v_)
/*     */     {
/* 893 */       this.point = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGrabpositionid(int _v_)
/*     */     {
/* 900 */       this.grabpositionid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 906 */       if (!(_o1_ instanceof Data)) return false;
/* 907 */       Data _o_ = (Data)_o1_;
/* 908 */       if (!this.ownpositions.equals(_o_.ownpositions)) return false;
/* 909 */       if (!this.sessiondata.equals(_o_.sessiondata)) return false;
/* 910 */       if (this.point != _o_.point) return false;
/* 911 */       if (this.grabpositionid != _o_.grabpositionid) return false;
/* 912 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 918 */       int _h_ = 0;
/* 919 */       _h_ += this.ownpositions.hashCode();
/* 920 */       _h_ += this.sessiondata.hashCode();
/* 921 */       _h_ += this.point;
/* 922 */       _h_ += this.grabpositionid;
/* 923 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 929 */       StringBuilder _sb_ = new StringBuilder();
/* 930 */       _sb_.append("(");
/* 931 */       _sb_.append(this.ownpositions);
/* 932 */       _sb_.append(",");
/* 933 */       _sb_.append(this.sessiondata);
/* 934 */       _sb_.append(",");
/* 935 */       _sb_.append(this.point);
/* 936 */       _sb_.append(",");
/* 937 */       _sb_.append(this.grabpositionid);
/* 938 */       _sb_.append(")");
/* 939 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RoleGrabData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */