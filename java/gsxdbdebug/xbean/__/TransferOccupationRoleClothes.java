/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ 
/*      */ public final class TransferOccupationRoleClothes extends XBean implements xbean.TransferOccupationRoleClothes
/*      */ {
/*      */   private int nextid;
/*      */   private int curid;
/*      */   private int defid;
/*      */   private int maxcount;
/*      */   private ArrayList<xbean.ClothColor> clothes;
/*      */   private HashMap<Integer, Integer> fashion_dress_cloth_map;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   28 */     this.nextid = 0;
/*   29 */     this.curid = -1;
/*   30 */     this.defid = -1;
/*   31 */     this.maxcount = 10;
/*   32 */     this.clothes.clear();
/*   33 */     this.fashion_dress_cloth_map.clear();
/*      */   }
/*      */   
/*      */   TransferOccupationRoleClothes(int __, XBean _xp_, String _vn_)
/*      */   {
/*   38 */     super(_xp_, _vn_);
/*   39 */     this.nextid = 0;
/*   40 */     this.curid = -1;
/*   41 */     this.defid = -1;
/*   42 */     this.maxcount = 10;
/*   43 */     this.clothes = new ArrayList();
/*   44 */     this.fashion_dress_cloth_map = new HashMap();
/*      */   }
/*      */   
/*      */   public TransferOccupationRoleClothes()
/*      */   {
/*   49 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public TransferOccupationRoleClothes(TransferOccupationRoleClothes _o_)
/*      */   {
/*   54 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   TransferOccupationRoleClothes(xbean.TransferOccupationRoleClothes _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   59 */     super(_xp_, _vn_);
/*   60 */     if ((_o1_ instanceof TransferOccupationRoleClothes)) { assign((TransferOccupationRoleClothes)_o1_);
/*   61 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   62 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   63 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(TransferOccupationRoleClothes _o_) {
/*   68 */     _o_._xdb_verify_unsafe_();
/*   69 */     this.nextid = _o_.nextid;
/*   70 */     this.curid = _o_.curid;
/*   71 */     this.defid = _o_.defid;
/*   72 */     this.maxcount = _o_.maxcount;
/*   73 */     this.clothes = new ArrayList();
/*   74 */     for (xbean.ClothColor _v_ : _o_.clothes)
/*   75 */       this.clothes.add(new ClothColor(_v_, this, "clothes"));
/*   76 */     this.fashion_dress_cloth_map = new HashMap();
/*   77 */     for (Map.Entry<Integer, Integer> _e_ : _o_.fashion_dress_cloth_map.entrySet()) {
/*   78 */       this.fashion_dress_cloth_map.put(_e_.getKey(), _e_.getValue());
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Data _o_) {
/*   83 */     this.nextid = _o_.nextid;
/*   84 */     this.curid = _o_.curid;
/*   85 */     this.defid = _o_.defid;
/*   86 */     this.maxcount = _o_.maxcount;
/*   87 */     this.clothes = new ArrayList();
/*   88 */     for (xbean.ClothColor _v_ : _o_.clothes)
/*   89 */       this.clothes.add(new ClothColor(_v_, this, "clothes"));
/*   90 */     this.fashion_dress_cloth_map = new HashMap();
/*   91 */     for (Map.Entry<Integer, Integer> _e_ : _o_.fashion_dress_cloth_map.entrySet()) {
/*   92 */       this.fashion_dress_cloth_map.put(_e_.getKey(), _e_.getValue());
/*      */     }
/*      */   }
/*      */   
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   98 */     _xdb_verify_unsafe_();
/*   99 */     _os_.marshal(this.nextid);
/*  100 */     _os_.marshal(this.curid);
/*  101 */     _os_.marshal(this.defid);
/*  102 */     _os_.marshal(this.maxcount);
/*  103 */     _os_.compact_uint32(this.clothes.size());
/*  104 */     for (xbean.ClothColor _v_ : this.clothes)
/*      */     {
/*  106 */       _v_.marshal(_os_);
/*      */     }
/*  108 */     _os_.compact_uint32(this.fashion_dress_cloth_map.size());
/*  109 */     for (Map.Entry<Integer, Integer> _e_ : this.fashion_dress_cloth_map.entrySet())
/*      */     {
/*  111 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  112 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  114 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  120 */     _xdb_verify_unsafe_();
/*  121 */     this.nextid = _os_.unmarshal_int();
/*  122 */     this.curid = _os_.unmarshal_int();
/*  123 */     this.defid = _os_.unmarshal_int();
/*  124 */     this.maxcount = _os_.unmarshal_int();
/*  125 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  127 */       xbean.ClothColor _v_ = new ClothColor(0, this, "clothes");
/*  128 */       _v_.unmarshal(_os_);
/*  129 */       this.clothes.add(_v_);
/*      */     }
/*      */     
/*  132 */     int size = _os_.uncompact_uint32();
/*  133 */     if (size >= 12)
/*      */     {
/*  135 */       this.fashion_dress_cloth_map = new HashMap(size * 2);
/*      */     }
/*  137 */     for (; size > 0; size--)
/*      */     {
/*  139 */       int _k_ = 0;
/*  140 */       _k_ = _os_.unmarshal_int();
/*  141 */       int _v_ = 0;
/*  142 */       _v_ = _os_.unmarshal_int();
/*  143 */       this.fashion_dress_cloth_map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  146 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  152 */     _xdb_verify_unsafe_();
/*  153 */     int _size_ = 0;
/*  154 */     _size_ += CodedOutputStream.computeInt32Size(1, this.nextid);
/*  155 */     _size_ += CodedOutputStream.computeInt32Size(2, this.curid);
/*  156 */     _size_ += CodedOutputStream.computeInt32Size(3, this.defid);
/*  157 */     _size_ += CodedOutputStream.computeInt32Size(4, this.maxcount);
/*  158 */     for (xbean.ClothColor _v_ : this.clothes)
/*      */     {
/*  160 */       _size_ += CodedOutputStream.computeMessageSize(5, _v_);
/*      */     }
/*  162 */     for (Map.Entry<Integer, Integer> _e_ : this.fashion_dress_cloth_map.entrySet())
/*      */     {
/*  164 */       _size_ += CodedOutputStream.computeInt32Size(6, ((Integer)_e_.getKey()).intValue());
/*  165 */       _size_ += CodedOutputStream.computeInt32Size(6, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  167 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  173 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  176 */       _output_.writeInt32(1, this.nextid);
/*  177 */       _output_.writeInt32(2, this.curid);
/*  178 */       _output_.writeInt32(3, this.defid);
/*  179 */       _output_.writeInt32(4, this.maxcount);
/*  180 */       for (xbean.ClothColor _v_ : this.clothes)
/*      */       {
/*  182 */         _output_.writeMessage(5, _v_);
/*      */       }
/*  184 */       for (Map.Entry<Integer, Integer> _e_ : this.fashion_dress_cloth_map.entrySet())
/*      */       {
/*  186 */         _output_.writeInt32(6, ((Integer)_e_.getKey()).intValue());
/*  187 */         _output_.writeInt32(6, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  192 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  194 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  200 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  203 */       boolean done = false;
/*  204 */       while (!done)
/*      */       {
/*  206 */         int tag = _input_.readTag();
/*  207 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  211 */           done = true;
/*  212 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  216 */           this.nextid = _input_.readInt32();
/*  217 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  221 */           this.curid = _input_.readInt32();
/*  222 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  226 */           this.defid = _input_.readInt32();
/*  227 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  231 */           this.maxcount = _input_.readInt32();
/*  232 */           break;
/*      */         
/*      */ 
/*      */         case 42: 
/*  236 */           xbean.ClothColor _v_ = new ClothColor(0, this, "clothes");
/*  237 */           _input_.readMessage(_v_);
/*  238 */           this.clothes.add(_v_);
/*  239 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  243 */           int _k_ = 0;
/*  244 */           _k_ = _input_.readInt32();
/*  245 */           int readTag = _input_.readTag();
/*  246 */           if (48 != readTag)
/*      */           {
/*  248 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  250 */           int _v_ = 0;
/*  251 */           _v_ = _input_.readInt32();
/*  252 */           this.fashion_dress_cloth_map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  253 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  257 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  259 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  268 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  272 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  274 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.TransferOccupationRoleClothes copy()
/*      */   {
/*  280 */     _xdb_verify_unsafe_();
/*  281 */     return new TransferOccupationRoleClothes(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.TransferOccupationRoleClothes toData()
/*      */   {
/*  287 */     _xdb_verify_unsafe_();
/*  288 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.TransferOccupationRoleClothes toBean()
/*      */   {
/*  293 */     _xdb_verify_unsafe_();
/*  294 */     return new TransferOccupationRoleClothes(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.TransferOccupationRoleClothes toDataIf()
/*      */   {
/*  300 */     _xdb_verify_unsafe_();
/*  301 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.TransferOccupationRoleClothes toBeanIf()
/*      */   {
/*  306 */     _xdb_verify_unsafe_();
/*  307 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  313 */     _xdb_verify_unsafe_();
/*  314 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getNextid()
/*      */   {
/*  321 */     _xdb_verify_unsafe_();
/*  322 */     return this.nextid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCurid()
/*      */   {
/*  329 */     _xdb_verify_unsafe_();
/*  330 */     return this.curid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getDefid()
/*      */   {
/*  337 */     _xdb_verify_unsafe_();
/*  338 */     return this.defid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getMaxcount()
/*      */   {
/*  345 */     _xdb_verify_unsafe_();
/*  346 */     return this.maxcount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<xbean.ClothColor> getClothes()
/*      */   {
/*  353 */     _xdb_verify_unsafe_();
/*  354 */     return xdb.Logs.logList(new LogKey(this, "clothes"), this.clothes);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<xbean.ClothColor> getClothesAsData()
/*      */   {
/*  360 */     _xdb_verify_unsafe_();
/*      */     
/*  362 */     TransferOccupationRoleClothes _o_ = this;
/*  363 */     List<xbean.ClothColor> clothes = new ArrayList();
/*  364 */     for (xbean.ClothColor _v_ : _o_.clothes)
/*  365 */       clothes.add(new ClothColor.Data(_v_));
/*  366 */     return clothes;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getFashion_dress_cloth_map()
/*      */   {
/*  373 */     _xdb_verify_unsafe_();
/*  374 */     return xdb.Logs.logMap(new LogKey(this, "fashion_dress_cloth_map"), this.fashion_dress_cloth_map);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getFashion_dress_cloth_mapAsData()
/*      */   {
/*  381 */     _xdb_verify_unsafe_();
/*      */     
/*  383 */     TransferOccupationRoleClothes _o_ = this;
/*  384 */     Map<Integer, Integer> fashion_dress_cloth_map = new HashMap();
/*  385 */     for (Map.Entry<Integer, Integer> _e_ : _o_.fashion_dress_cloth_map.entrySet())
/*  386 */       fashion_dress_cloth_map.put(_e_.getKey(), _e_.getValue());
/*  387 */     return fashion_dress_cloth_map;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setNextid(int _v_)
/*      */   {
/*  394 */     _xdb_verify_unsafe_();
/*  395 */     xdb.Logs.logIf(new LogKey(this, "nextid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  399 */         new xdb.logs.LogInt(this, TransferOccupationRoleClothes.this.nextid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  403 */             TransferOccupationRoleClothes.this.nextid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  407 */     });
/*  408 */     this.nextid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCurid(int _v_)
/*      */   {
/*  415 */     _xdb_verify_unsafe_();
/*  416 */     xdb.Logs.logIf(new LogKey(this, "curid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  420 */         new xdb.logs.LogInt(this, TransferOccupationRoleClothes.this.curid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  424 */             TransferOccupationRoleClothes.this.curid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  428 */     });
/*  429 */     this.curid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setDefid(int _v_)
/*      */   {
/*  436 */     _xdb_verify_unsafe_();
/*  437 */     xdb.Logs.logIf(new LogKey(this, "defid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  441 */         new xdb.logs.LogInt(this, TransferOccupationRoleClothes.this.defid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  445 */             TransferOccupationRoleClothes.this.defid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  449 */     });
/*  450 */     this.defid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMaxcount(int _v_)
/*      */   {
/*  457 */     _xdb_verify_unsafe_();
/*  458 */     xdb.Logs.logIf(new LogKey(this, "maxcount")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  462 */         new xdb.logs.LogInt(this, TransferOccupationRoleClothes.this.maxcount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  466 */             TransferOccupationRoleClothes.this.maxcount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  470 */     });
/*  471 */     this.maxcount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  477 */     _xdb_verify_unsafe_();
/*  478 */     TransferOccupationRoleClothes _o_ = null;
/*  479 */     if ((_o1_ instanceof TransferOccupationRoleClothes)) { _o_ = (TransferOccupationRoleClothes)_o1_;
/*  480 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  481 */       return false;
/*  482 */     if (this.nextid != _o_.nextid) return false;
/*  483 */     if (this.curid != _o_.curid) return false;
/*  484 */     if (this.defid != _o_.defid) return false;
/*  485 */     if (this.maxcount != _o_.maxcount) return false;
/*  486 */     if (!this.clothes.equals(_o_.clothes)) return false;
/*  487 */     if (!this.fashion_dress_cloth_map.equals(_o_.fashion_dress_cloth_map)) return false;
/*  488 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  494 */     _xdb_verify_unsafe_();
/*  495 */     int _h_ = 0;
/*  496 */     _h_ += this.nextid;
/*  497 */     _h_ += this.curid;
/*  498 */     _h_ += this.defid;
/*  499 */     _h_ += this.maxcount;
/*  500 */     _h_ += this.clothes.hashCode();
/*  501 */     _h_ += this.fashion_dress_cloth_map.hashCode();
/*  502 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  508 */     _xdb_verify_unsafe_();
/*  509 */     StringBuilder _sb_ = new StringBuilder();
/*  510 */     _sb_.append("(");
/*  511 */     _sb_.append(this.nextid);
/*  512 */     _sb_.append(",");
/*  513 */     _sb_.append(this.curid);
/*  514 */     _sb_.append(",");
/*  515 */     _sb_.append(this.defid);
/*  516 */     _sb_.append(",");
/*  517 */     _sb_.append(this.maxcount);
/*  518 */     _sb_.append(",");
/*  519 */     _sb_.append(this.clothes);
/*  520 */     _sb_.append(",");
/*  521 */     _sb_.append(this.fashion_dress_cloth_map);
/*  522 */     _sb_.append(")");
/*  523 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  529 */     ListenableBean lb = new ListenableBean();
/*  530 */     lb.add(new ListenableChanged().setVarName("nextid"));
/*  531 */     lb.add(new ListenableChanged().setVarName("curid"));
/*  532 */     lb.add(new ListenableChanged().setVarName("defid"));
/*  533 */     lb.add(new ListenableChanged().setVarName("maxcount"));
/*  534 */     lb.add(new ListenableChanged().setVarName("clothes"));
/*  535 */     lb.add(new xdb.logs.ListenableMap().setVarName("fashion_dress_cloth_map"));
/*  536 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.TransferOccupationRoleClothes {
/*      */     private Const() {}
/*      */     
/*      */     TransferOccupationRoleClothes nThis() {
/*  543 */       return TransferOccupationRoleClothes.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  549 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.TransferOccupationRoleClothes copy()
/*      */     {
/*  555 */       return TransferOccupationRoleClothes.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.TransferOccupationRoleClothes toData()
/*      */     {
/*  561 */       return TransferOccupationRoleClothes.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.TransferOccupationRoleClothes toBean()
/*      */     {
/*  566 */       return TransferOccupationRoleClothes.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.TransferOccupationRoleClothes toDataIf()
/*      */     {
/*  572 */       return TransferOccupationRoleClothes.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.TransferOccupationRoleClothes toBeanIf()
/*      */     {
/*  577 */       return TransferOccupationRoleClothes.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getNextid()
/*      */     {
/*  584 */       TransferOccupationRoleClothes.this._xdb_verify_unsafe_();
/*  585 */       return TransferOccupationRoleClothes.this.nextid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurid()
/*      */     {
/*  592 */       TransferOccupationRoleClothes.this._xdb_verify_unsafe_();
/*  593 */       return TransferOccupationRoleClothes.this.curid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDefid()
/*      */     {
/*  600 */       TransferOccupationRoleClothes.this._xdb_verify_unsafe_();
/*  601 */       return TransferOccupationRoleClothes.this.defid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMaxcount()
/*      */     {
/*  608 */       TransferOccupationRoleClothes.this._xdb_verify_unsafe_();
/*  609 */       return TransferOccupationRoleClothes.this.maxcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.ClothColor> getClothes()
/*      */     {
/*  616 */       TransferOccupationRoleClothes.this._xdb_verify_unsafe_();
/*  617 */       return xdb.Consts.constList(TransferOccupationRoleClothes.this.clothes);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<xbean.ClothColor> getClothesAsData()
/*      */     {
/*  623 */       TransferOccupationRoleClothes.this._xdb_verify_unsafe_();
/*      */       
/*  625 */       TransferOccupationRoleClothes _o_ = TransferOccupationRoleClothes.this;
/*  626 */       List<xbean.ClothColor> clothes = new ArrayList();
/*  627 */       for (xbean.ClothColor _v_ : _o_.clothes)
/*  628 */         clothes.add(new ClothColor.Data(_v_));
/*  629 */       return clothes;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getFashion_dress_cloth_map()
/*      */     {
/*  636 */       TransferOccupationRoleClothes.this._xdb_verify_unsafe_();
/*  637 */       return xdb.Consts.constMap(TransferOccupationRoleClothes.this.fashion_dress_cloth_map);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getFashion_dress_cloth_mapAsData()
/*      */     {
/*  644 */       TransferOccupationRoleClothes.this._xdb_verify_unsafe_();
/*      */       
/*  646 */       TransferOccupationRoleClothes _o_ = TransferOccupationRoleClothes.this;
/*  647 */       Map<Integer, Integer> fashion_dress_cloth_map = new HashMap();
/*  648 */       for (Map.Entry<Integer, Integer> _e_ : _o_.fashion_dress_cloth_map.entrySet())
/*  649 */         fashion_dress_cloth_map.put(_e_.getKey(), _e_.getValue());
/*  650 */       return fashion_dress_cloth_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNextid(int _v_)
/*      */     {
/*  657 */       TransferOccupationRoleClothes.this._xdb_verify_unsafe_();
/*  658 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurid(int _v_)
/*      */     {
/*  665 */       TransferOccupationRoleClothes.this._xdb_verify_unsafe_();
/*  666 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDefid(int _v_)
/*      */     {
/*  673 */       TransferOccupationRoleClothes.this._xdb_verify_unsafe_();
/*  674 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMaxcount(int _v_)
/*      */     {
/*  681 */       TransferOccupationRoleClothes.this._xdb_verify_unsafe_();
/*  682 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  688 */       TransferOccupationRoleClothes.this._xdb_verify_unsafe_();
/*  689 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  695 */       TransferOccupationRoleClothes.this._xdb_verify_unsafe_();
/*  696 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  702 */       return TransferOccupationRoleClothes.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  708 */       return TransferOccupationRoleClothes.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  714 */       TransferOccupationRoleClothes.this._xdb_verify_unsafe_();
/*  715 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  721 */       return TransferOccupationRoleClothes.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  727 */       return TransferOccupationRoleClothes.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  733 */       TransferOccupationRoleClothes.this._xdb_verify_unsafe_();
/*  734 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  740 */       return TransferOccupationRoleClothes.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  746 */       return TransferOccupationRoleClothes.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  752 */       return TransferOccupationRoleClothes.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  758 */       return TransferOccupationRoleClothes.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  764 */       return TransferOccupationRoleClothes.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  770 */       return TransferOccupationRoleClothes.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  776 */       return TransferOccupationRoleClothes.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.TransferOccupationRoleClothes
/*      */   {
/*      */     private int nextid;
/*      */     
/*      */     private int curid;
/*      */     
/*      */     private int defid;
/*      */     
/*      */     private int maxcount;
/*      */     
/*      */     private ArrayList<xbean.ClothColor> clothes;
/*      */     
/*      */     private HashMap<Integer, Integer> fashion_dress_cloth_map;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  798 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  803 */       this.nextid = 0;
/*  804 */       this.curid = -1;
/*  805 */       this.defid = -1;
/*  806 */       this.maxcount = 10;
/*  807 */       this.clothes = new ArrayList();
/*  808 */       this.fashion_dress_cloth_map = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.TransferOccupationRoleClothes _o1_)
/*      */     {
/*  813 */       if ((_o1_ instanceof TransferOccupationRoleClothes)) { assign((TransferOccupationRoleClothes)_o1_);
/*  814 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  815 */       } else if ((_o1_ instanceof TransferOccupationRoleClothes.Const)) assign(((TransferOccupationRoleClothes.Const)_o1_).nThis()); else {
/*  816 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(TransferOccupationRoleClothes _o_) {
/*  821 */       this.nextid = _o_.nextid;
/*  822 */       this.curid = _o_.curid;
/*  823 */       this.defid = _o_.defid;
/*  824 */       this.maxcount = _o_.maxcount;
/*  825 */       this.clothes = new ArrayList();
/*  826 */       for (xbean.ClothColor _v_ : _o_.clothes)
/*  827 */         this.clothes.add(new ClothColor.Data(_v_));
/*  828 */       this.fashion_dress_cloth_map = new HashMap();
/*  829 */       for (Map.Entry<Integer, Integer> _e_ : _o_.fashion_dress_cloth_map.entrySet()) {
/*  830 */         this.fashion_dress_cloth_map.put(_e_.getKey(), _e_.getValue());
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Data _o_) {
/*  835 */       this.nextid = _o_.nextid;
/*  836 */       this.curid = _o_.curid;
/*  837 */       this.defid = _o_.defid;
/*  838 */       this.maxcount = _o_.maxcount;
/*  839 */       this.clothes = new ArrayList();
/*  840 */       for (xbean.ClothColor _v_ : _o_.clothes)
/*  841 */         this.clothes.add(new ClothColor.Data(_v_));
/*  842 */       this.fashion_dress_cloth_map = new HashMap();
/*  843 */       for (Map.Entry<Integer, Integer> _e_ : _o_.fashion_dress_cloth_map.entrySet()) {
/*  844 */         this.fashion_dress_cloth_map.put(_e_.getKey(), _e_.getValue());
/*      */       }
/*      */     }
/*      */     
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  850 */       _os_.marshal(this.nextid);
/*  851 */       _os_.marshal(this.curid);
/*  852 */       _os_.marshal(this.defid);
/*  853 */       _os_.marshal(this.maxcount);
/*  854 */       _os_.compact_uint32(this.clothes.size());
/*  855 */       for (xbean.ClothColor _v_ : this.clothes)
/*      */       {
/*  857 */         _v_.marshal(_os_);
/*      */       }
/*  859 */       _os_.compact_uint32(this.fashion_dress_cloth_map.size());
/*  860 */       for (Map.Entry<Integer, Integer> _e_ : this.fashion_dress_cloth_map.entrySet())
/*      */       {
/*  862 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  863 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/*  865 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  871 */       this.nextid = _os_.unmarshal_int();
/*  872 */       this.curid = _os_.unmarshal_int();
/*  873 */       this.defid = _os_.unmarshal_int();
/*  874 */       this.maxcount = _os_.unmarshal_int();
/*  875 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  877 */         xbean.ClothColor _v_ = xbean.Pod.newClothColorData();
/*  878 */         _v_.unmarshal(_os_);
/*  879 */         this.clothes.add(_v_);
/*      */       }
/*      */       
/*  882 */       int size = _os_.uncompact_uint32();
/*  883 */       if (size >= 12)
/*      */       {
/*  885 */         this.fashion_dress_cloth_map = new HashMap(size * 2);
/*      */       }
/*  887 */       for (; size > 0; size--)
/*      */       {
/*  889 */         int _k_ = 0;
/*  890 */         _k_ = _os_.unmarshal_int();
/*  891 */         int _v_ = 0;
/*  892 */         _v_ = _os_.unmarshal_int();
/*  893 */         this.fashion_dress_cloth_map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*  896 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  902 */       int _size_ = 0;
/*  903 */       _size_ += CodedOutputStream.computeInt32Size(1, this.nextid);
/*  904 */       _size_ += CodedOutputStream.computeInt32Size(2, this.curid);
/*  905 */       _size_ += CodedOutputStream.computeInt32Size(3, this.defid);
/*  906 */       _size_ += CodedOutputStream.computeInt32Size(4, this.maxcount);
/*  907 */       for (xbean.ClothColor _v_ : this.clothes)
/*      */       {
/*  909 */         _size_ += CodedOutputStream.computeMessageSize(5, _v_);
/*      */       }
/*  911 */       for (Map.Entry<Integer, Integer> _e_ : this.fashion_dress_cloth_map.entrySet())
/*      */       {
/*  913 */         _size_ += CodedOutputStream.computeInt32Size(6, ((Integer)_e_.getKey()).intValue());
/*  914 */         _size_ += CodedOutputStream.computeInt32Size(6, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  916 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  924 */         _output_.writeInt32(1, this.nextid);
/*  925 */         _output_.writeInt32(2, this.curid);
/*  926 */         _output_.writeInt32(3, this.defid);
/*  927 */         _output_.writeInt32(4, this.maxcount);
/*  928 */         for (xbean.ClothColor _v_ : this.clothes)
/*      */         {
/*  930 */           _output_.writeMessage(5, _v_);
/*      */         }
/*  932 */         for (Map.Entry<Integer, Integer> _e_ : this.fashion_dress_cloth_map.entrySet())
/*      */         {
/*  934 */           _output_.writeInt32(6, ((Integer)_e_.getKey()).intValue());
/*  935 */           _output_.writeInt32(6, ((Integer)_e_.getValue()).intValue());
/*      */         }
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/*  940 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  942 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  950 */         boolean done = false;
/*  951 */         while (!done)
/*      */         {
/*  953 */           int tag = _input_.readTag();
/*  954 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  958 */             done = true;
/*  959 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  963 */             this.nextid = _input_.readInt32();
/*  964 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  968 */             this.curid = _input_.readInt32();
/*  969 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  973 */             this.defid = _input_.readInt32();
/*  974 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  978 */             this.maxcount = _input_.readInt32();
/*  979 */             break;
/*      */           
/*      */ 
/*      */           case 42: 
/*  983 */             xbean.ClothColor _v_ = xbean.Pod.newClothColorData();
/*  984 */             _input_.readMessage(_v_);
/*  985 */             this.clothes.add(_v_);
/*  986 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/*  990 */             int _k_ = 0;
/*  991 */             _k_ = _input_.readInt32();
/*  992 */             int readTag = _input_.readTag();
/*  993 */             if (48 != readTag)
/*      */             {
/*  995 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  997 */             int _v_ = 0;
/*  998 */             _v_ = _input_.readInt32();
/*  999 */             this.fashion_dress_cloth_map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 1000 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1004 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1006 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1015 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/* 1019 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1021 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.TransferOccupationRoleClothes copy()
/*      */     {
/* 1027 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.TransferOccupationRoleClothes toData()
/*      */     {
/* 1033 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.TransferOccupationRoleClothes toBean()
/*      */     {
/* 1038 */       return new TransferOccupationRoleClothes(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.TransferOccupationRoleClothes toDataIf()
/*      */     {
/* 1044 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.TransferOccupationRoleClothes toBeanIf()
/*      */     {
/* 1049 */       return new TransferOccupationRoleClothes(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1055 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1059 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1063 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1067 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1071 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1075 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1079 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getNextid()
/*      */     {
/* 1086 */       return this.nextid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurid()
/*      */     {
/* 1093 */       return this.curid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDefid()
/*      */     {
/* 1100 */       return this.defid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMaxcount()
/*      */     {
/* 1107 */       return this.maxcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.ClothColor> getClothes()
/*      */     {
/* 1114 */       return this.clothes;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.ClothColor> getClothesAsData()
/*      */     {
/* 1121 */       return this.clothes;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getFashion_dress_cloth_map()
/*      */     {
/* 1128 */       return this.fashion_dress_cloth_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getFashion_dress_cloth_mapAsData()
/*      */     {
/* 1135 */       return this.fashion_dress_cloth_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNextid(int _v_)
/*      */     {
/* 1142 */       this.nextid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurid(int _v_)
/*      */     {
/* 1149 */       this.curid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDefid(int _v_)
/*      */     {
/* 1156 */       this.defid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMaxcount(int _v_)
/*      */     {
/* 1163 */       this.maxcount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1169 */       if (!(_o1_ instanceof Data)) return false;
/* 1170 */       Data _o_ = (Data)_o1_;
/* 1171 */       if (this.nextid != _o_.nextid) return false;
/* 1172 */       if (this.curid != _o_.curid) return false;
/* 1173 */       if (this.defid != _o_.defid) return false;
/* 1174 */       if (this.maxcount != _o_.maxcount) return false;
/* 1175 */       if (!this.clothes.equals(_o_.clothes)) return false;
/* 1176 */       if (!this.fashion_dress_cloth_map.equals(_o_.fashion_dress_cloth_map)) return false;
/* 1177 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1183 */       int _h_ = 0;
/* 1184 */       _h_ += this.nextid;
/* 1185 */       _h_ += this.curid;
/* 1186 */       _h_ += this.defid;
/* 1187 */       _h_ += this.maxcount;
/* 1188 */       _h_ += this.clothes.hashCode();
/* 1189 */       _h_ += this.fashion_dress_cloth_map.hashCode();
/* 1190 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1196 */       StringBuilder _sb_ = new StringBuilder();
/* 1197 */       _sb_.append("(");
/* 1198 */       _sb_.append(this.nextid);
/* 1199 */       _sb_.append(",");
/* 1200 */       _sb_.append(this.curid);
/* 1201 */       _sb_.append(",");
/* 1202 */       _sb_.append(this.defid);
/* 1203 */       _sb_.append(",");
/* 1204 */       _sb_.append(this.maxcount);
/* 1205 */       _sb_.append(",");
/* 1206 */       _sb_.append(this.clothes);
/* 1207 */       _sb_.append(",");
/* 1208 */       _sb_.append(this.fashion_dress_cloth_map);
/* 1209 */       _sb_.append(")");
/* 1210 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\TransferOccupationRoleClothes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */