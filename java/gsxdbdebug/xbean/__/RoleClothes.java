/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
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
/*      */ public final class RoleClothes extends XBean implements xbean.RoleClothes
/*      */ {
/*      */   private int nextid;
/*      */   private int curid;
/*      */   private int defid;
/*      */   private int maxcount;
/*      */   private ArrayList<xbean.ClothColor> clothes;
/*      */   private HashMap<Integer, Integer> fashion_dress_cloth_map;
/*      */   private HashMap<Integer, xbean.TransferOccupationRoleClothes> transfer_occupation_role_clothes;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   30 */     this.nextid = 0;
/*   31 */     this.curid = -1;
/*   32 */     this.defid = -1;
/*   33 */     this.maxcount = 10;
/*   34 */     this.clothes.clear();
/*   35 */     this.fashion_dress_cloth_map.clear();
/*   36 */     this.transfer_occupation_role_clothes.clear();
/*      */   }
/*      */   
/*      */   RoleClothes(int __, XBean _xp_, String _vn_)
/*      */   {
/*   41 */     super(_xp_, _vn_);
/*   42 */     this.nextid = 0;
/*   43 */     this.curid = -1;
/*   44 */     this.defid = -1;
/*   45 */     this.maxcount = 10;
/*   46 */     this.clothes = new ArrayList();
/*   47 */     this.fashion_dress_cloth_map = new HashMap();
/*   48 */     this.transfer_occupation_role_clothes = new HashMap();
/*      */   }
/*      */   
/*      */   public RoleClothes()
/*      */   {
/*   53 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public RoleClothes(RoleClothes _o_)
/*      */   {
/*   58 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   RoleClothes(xbean.RoleClothes _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   63 */     super(_xp_, _vn_);
/*   64 */     if ((_o1_ instanceof RoleClothes)) { assign((RoleClothes)_o1_);
/*   65 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   66 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   67 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(RoleClothes _o_) {
/*   72 */     _o_._xdb_verify_unsafe_();
/*   73 */     this.nextid = _o_.nextid;
/*   74 */     this.curid = _o_.curid;
/*   75 */     this.defid = _o_.defid;
/*   76 */     this.maxcount = _o_.maxcount;
/*   77 */     this.clothes = new ArrayList();
/*   78 */     for (xbean.ClothColor _v_ : _o_.clothes)
/*   79 */       this.clothes.add(new ClothColor(_v_, this, "clothes"));
/*   80 */     this.fashion_dress_cloth_map = new HashMap();
/*   81 */     for (Map.Entry<Integer, Integer> _e_ : _o_.fashion_dress_cloth_map.entrySet())
/*   82 */       this.fashion_dress_cloth_map.put(_e_.getKey(), _e_.getValue());
/*   83 */     this.transfer_occupation_role_clothes = new HashMap();
/*   84 */     for (Map.Entry<Integer, xbean.TransferOccupationRoleClothes> _e_ : _o_.transfer_occupation_role_clothes.entrySet()) {
/*   85 */       this.transfer_occupation_role_clothes.put(_e_.getKey(), new TransferOccupationRoleClothes((xbean.TransferOccupationRoleClothes)_e_.getValue(), this, "transfer_occupation_role_clothes"));
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Data _o_) {
/*   90 */     this.nextid = _o_.nextid;
/*   91 */     this.curid = _o_.curid;
/*   92 */     this.defid = _o_.defid;
/*   93 */     this.maxcount = _o_.maxcount;
/*   94 */     this.clothes = new ArrayList();
/*   95 */     for (xbean.ClothColor _v_ : _o_.clothes)
/*   96 */       this.clothes.add(new ClothColor(_v_, this, "clothes"));
/*   97 */     this.fashion_dress_cloth_map = new HashMap();
/*   98 */     for (Map.Entry<Integer, Integer> _e_ : _o_.fashion_dress_cloth_map.entrySet())
/*   99 */       this.fashion_dress_cloth_map.put(_e_.getKey(), _e_.getValue());
/*  100 */     this.transfer_occupation_role_clothes = new HashMap();
/*  101 */     for (Map.Entry<Integer, xbean.TransferOccupationRoleClothes> _e_ : _o_.transfer_occupation_role_clothes.entrySet()) {
/*  102 */       this.transfer_occupation_role_clothes.put(_e_.getKey(), new TransferOccupationRoleClothes((xbean.TransferOccupationRoleClothes)_e_.getValue(), this, "transfer_occupation_role_clothes"));
/*      */     }
/*      */   }
/*      */   
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  108 */     _xdb_verify_unsafe_();
/*  109 */     _os_.marshal(this.nextid);
/*  110 */     _os_.marshal(this.curid);
/*  111 */     _os_.marshal(this.defid);
/*  112 */     _os_.marshal(this.maxcount);
/*  113 */     _os_.compact_uint32(this.clothes.size());
/*  114 */     for (xbean.ClothColor _v_ : this.clothes)
/*      */     {
/*  116 */       _v_.marshal(_os_);
/*      */     }
/*  118 */     _os_.compact_uint32(this.fashion_dress_cloth_map.size());
/*  119 */     for (Map.Entry<Integer, Integer> _e_ : this.fashion_dress_cloth_map.entrySet())
/*      */     {
/*  121 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  122 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  124 */     _os_.compact_uint32(this.transfer_occupation_role_clothes.size());
/*  125 */     for (Map.Entry<Integer, xbean.TransferOccupationRoleClothes> _e_ : this.transfer_occupation_role_clothes.entrySet())
/*      */     {
/*  127 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  128 */       ((xbean.TransferOccupationRoleClothes)_e_.getValue()).marshal(_os_);
/*      */     }
/*  130 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  136 */     _xdb_verify_unsafe_();
/*  137 */     this.nextid = _os_.unmarshal_int();
/*  138 */     this.curid = _os_.unmarshal_int();
/*  139 */     this.defid = _os_.unmarshal_int();
/*  140 */     this.maxcount = _os_.unmarshal_int();
/*  141 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  143 */       xbean.ClothColor _v_ = new ClothColor(0, this, "clothes");
/*  144 */       _v_.unmarshal(_os_);
/*  145 */       this.clothes.add(_v_);
/*      */     }
/*      */     
/*  148 */     int size = _os_.uncompact_uint32();
/*  149 */     if (size >= 12)
/*      */     {
/*  151 */       this.fashion_dress_cloth_map = new HashMap(size * 2);
/*      */     }
/*  153 */     for (; size > 0; size--)
/*      */     {
/*  155 */       int _k_ = 0;
/*  156 */       _k_ = _os_.unmarshal_int();
/*  157 */       int _v_ = 0;
/*  158 */       _v_ = _os_.unmarshal_int();
/*  159 */       this.fashion_dress_cloth_map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*      */ 
/*  163 */     int size = _os_.uncompact_uint32();
/*  164 */     if (size >= 12)
/*      */     {
/*  166 */       this.transfer_occupation_role_clothes = new HashMap(size * 2);
/*      */     }
/*  168 */     for (; size > 0; size--)
/*      */     {
/*  170 */       int _k_ = 0;
/*  171 */       _k_ = _os_.unmarshal_int();
/*  172 */       xbean.TransferOccupationRoleClothes _v_ = new TransferOccupationRoleClothes(0, this, "transfer_occupation_role_clothes");
/*  173 */       _v_.unmarshal(_os_);
/*  174 */       this.transfer_occupation_role_clothes.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  177 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  183 */     _xdb_verify_unsafe_();
/*  184 */     int _size_ = 0;
/*  185 */     _size_ += CodedOutputStream.computeInt32Size(1, this.nextid);
/*  186 */     _size_ += CodedOutputStream.computeInt32Size(2, this.curid);
/*  187 */     _size_ += CodedOutputStream.computeInt32Size(3, this.defid);
/*  188 */     _size_ += CodedOutputStream.computeInt32Size(4, this.maxcount);
/*  189 */     for (xbean.ClothColor _v_ : this.clothes)
/*      */     {
/*  191 */       _size_ += CodedOutputStream.computeMessageSize(5, _v_);
/*      */     }
/*  193 */     for (Map.Entry<Integer, Integer> _e_ : this.fashion_dress_cloth_map.entrySet())
/*      */     {
/*  195 */       _size_ += CodedOutputStream.computeInt32Size(6, ((Integer)_e_.getKey()).intValue());
/*  196 */       _size_ += CodedOutputStream.computeInt32Size(6, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  198 */     for (Map.Entry<Integer, xbean.TransferOccupationRoleClothes> _e_ : this.transfer_occupation_role_clothes.entrySet())
/*      */     {
/*  200 */       _size_ += CodedOutputStream.computeInt32Size(7, ((Integer)_e_.getKey()).intValue());
/*  201 */       _size_ += CodedOutputStream.computeMessageSize(7, (ppbio.Message)_e_.getValue());
/*      */     }
/*  203 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  209 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  212 */       _output_.writeInt32(1, this.nextid);
/*  213 */       _output_.writeInt32(2, this.curid);
/*  214 */       _output_.writeInt32(3, this.defid);
/*  215 */       _output_.writeInt32(4, this.maxcount);
/*  216 */       for (xbean.ClothColor _v_ : this.clothes)
/*      */       {
/*  218 */         _output_.writeMessage(5, _v_);
/*      */       }
/*  220 */       for (Map.Entry<Integer, Integer> _e_ : this.fashion_dress_cloth_map.entrySet())
/*      */       {
/*  222 */         _output_.writeInt32(6, ((Integer)_e_.getKey()).intValue());
/*  223 */         _output_.writeInt32(6, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  225 */       for (Map.Entry<Integer, xbean.TransferOccupationRoleClothes> _e_ : this.transfer_occupation_role_clothes.entrySet())
/*      */       {
/*  227 */         _output_.writeInt32(7, ((Integer)_e_.getKey()).intValue());
/*  228 */         _output_.writeMessage(7, (ppbio.Message)_e_.getValue());
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  233 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  235 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  241 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  244 */       boolean done = false;
/*  245 */       while (!done)
/*      */       {
/*  247 */         int tag = _input_.readTag();
/*  248 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  252 */           done = true;
/*  253 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  257 */           this.nextid = _input_.readInt32();
/*  258 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  262 */           this.curid = _input_.readInt32();
/*  263 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  267 */           this.defid = _input_.readInt32();
/*  268 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  272 */           this.maxcount = _input_.readInt32();
/*  273 */           break;
/*      */         
/*      */ 
/*      */         case 42: 
/*  277 */           xbean.ClothColor _v_ = new ClothColor(0, this, "clothes");
/*  278 */           _input_.readMessage(_v_);
/*  279 */           this.clothes.add(_v_);
/*  280 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  284 */           int _k_ = 0;
/*  285 */           _k_ = _input_.readInt32();
/*  286 */           int readTag = _input_.readTag();
/*  287 */           if (48 != readTag)
/*      */           {
/*  289 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  291 */           int _v_ = 0;
/*  292 */           _v_ = _input_.readInt32();
/*  293 */           this.fashion_dress_cloth_map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  294 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  298 */           int _k_ = 0;
/*  299 */           _k_ = _input_.readInt32();
/*  300 */           int readTag = _input_.readTag();
/*  301 */           if (58 != readTag)
/*      */           {
/*  303 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  305 */           xbean.TransferOccupationRoleClothes _v_ = new TransferOccupationRoleClothes(0, this, "transfer_occupation_role_clothes");
/*  306 */           _input_.readMessage(_v_);
/*  307 */           this.transfer_occupation_role_clothes.put(Integer.valueOf(_k_), _v_);
/*  308 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  312 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  314 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  323 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  327 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  329 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RoleClothes copy()
/*      */   {
/*  335 */     _xdb_verify_unsafe_();
/*  336 */     return new RoleClothes(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RoleClothes toData()
/*      */   {
/*  342 */     _xdb_verify_unsafe_();
/*  343 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.RoleClothes toBean()
/*      */   {
/*  348 */     _xdb_verify_unsafe_();
/*  349 */     return new RoleClothes(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RoleClothes toDataIf()
/*      */   {
/*  355 */     _xdb_verify_unsafe_();
/*  356 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.RoleClothes toBeanIf()
/*      */   {
/*  361 */     _xdb_verify_unsafe_();
/*  362 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  368 */     _xdb_verify_unsafe_();
/*  369 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getNextid()
/*      */   {
/*  376 */     _xdb_verify_unsafe_();
/*  377 */     return this.nextid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCurid()
/*      */   {
/*  384 */     _xdb_verify_unsafe_();
/*  385 */     return this.curid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getDefid()
/*      */   {
/*  392 */     _xdb_verify_unsafe_();
/*  393 */     return this.defid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getMaxcount()
/*      */   {
/*  400 */     _xdb_verify_unsafe_();
/*  401 */     return this.maxcount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<xbean.ClothColor> getClothes()
/*      */   {
/*  408 */     _xdb_verify_unsafe_();
/*  409 */     return xdb.Logs.logList(new LogKey(this, "clothes"), this.clothes);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<xbean.ClothColor> getClothesAsData()
/*      */   {
/*  415 */     _xdb_verify_unsafe_();
/*      */     
/*  417 */     RoleClothes _o_ = this;
/*  418 */     List<xbean.ClothColor> clothes = new ArrayList();
/*  419 */     for (xbean.ClothColor _v_ : _o_.clothes)
/*  420 */       clothes.add(new ClothColor.Data(_v_));
/*  421 */     return clothes;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getFashion_dress_cloth_map()
/*      */   {
/*  428 */     _xdb_verify_unsafe_();
/*  429 */     return xdb.Logs.logMap(new LogKey(this, "fashion_dress_cloth_map"), this.fashion_dress_cloth_map);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getFashion_dress_cloth_mapAsData()
/*      */   {
/*  436 */     _xdb_verify_unsafe_();
/*      */     
/*  438 */     RoleClothes _o_ = this;
/*  439 */     Map<Integer, Integer> fashion_dress_cloth_map = new HashMap();
/*  440 */     for (Map.Entry<Integer, Integer> _e_ : _o_.fashion_dress_cloth_map.entrySet())
/*  441 */       fashion_dress_cloth_map.put(_e_.getKey(), _e_.getValue());
/*  442 */     return fashion_dress_cloth_map;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.TransferOccupationRoleClothes> getTransfer_occupation_role_clothes()
/*      */   {
/*  449 */     _xdb_verify_unsafe_();
/*  450 */     return xdb.Logs.logMap(new LogKey(this, "transfer_occupation_role_clothes"), this.transfer_occupation_role_clothes);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.TransferOccupationRoleClothes> getTransfer_occupation_role_clothesAsData()
/*      */   {
/*  457 */     _xdb_verify_unsafe_();
/*      */     
/*  459 */     RoleClothes _o_ = this;
/*  460 */     Map<Integer, xbean.TransferOccupationRoleClothes> transfer_occupation_role_clothes = new HashMap();
/*  461 */     for (Map.Entry<Integer, xbean.TransferOccupationRoleClothes> _e_ : _o_.transfer_occupation_role_clothes.entrySet())
/*  462 */       transfer_occupation_role_clothes.put(_e_.getKey(), new TransferOccupationRoleClothes.Data((xbean.TransferOccupationRoleClothes)_e_.getValue()));
/*  463 */     return transfer_occupation_role_clothes;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setNextid(int _v_)
/*      */   {
/*  470 */     _xdb_verify_unsafe_();
/*  471 */     xdb.Logs.logIf(new LogKey(this, "nextid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  475 */         new xdb.logs.LogInt(this, RoleClothes.this.nextid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  479 */             RoleClothes.this.nextid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  483 */     });
/*  484 */     this.nextid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCurid(int _v_)
/*      */   {
/*  491 */     _xdb_verify_unsafe_();
/*  492 */     xdb.Logs.logIf(new LogKey(this, "curid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  496 */         new xdb.logs.LogInt(this, RoleClothes.this.curid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  500 */             RoleClothes.this.curid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  504 */     });
/*  505 */     this.curid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setDefid(int _v_)
/*      */   {
/*  512 */     _xdb_verify_unsafe_();
/*  513 */     xdb.Logs.logIf(new LogKey(this, "defid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  517 */         new xdb.logs.LogInt(this, RoleClothes.this.defid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  521 */             RoleClothes.this.defid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  525 */     });
/*  526 */     this.defid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMaxcount(int _v_)
/*      */   {
/*  533 */     _xdb_verify_unsafe_();
/*  534 */     xdb.Logs.logIf(new LogKey(this, "maxcount")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  538 */         new xdb.logs.LogInt(this, RoleClothes.this.maxcount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  542 */             RoleClothes.this.maxcount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  546 */     });
/*  547 */     this.maxcount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  553 */     _xdb_verify_unsafe_();
/*  554 */     RoleClothes _o_ = null;
/*  555 */     if ((_o1_ instanceof RoleClothes)) { _o_ = (RoleClothes)_o1_;
/*  556 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  557 */       return false;
/*  558 */     if (this.nextid != _o_.nextid) return false;
/*  559 */     if (this.curid != _o_.curid) return false;
/*  560 */     if (this.defid != _o_.defid) return false;
/*  561 */     if (this.maxcount != _o_.maxcount) return false;
/*  562 */     if (!this.clothes.equals(_o_.clothes)) return false;
/*  563 */     if (!this.fashion_dress_cloth_map.equals(_o_.fashion_dress_cloth_map)) return false;
/*  564 */     if (!this.transfer_occupation_role_clothes.equals(_o_.transfer_occupation_role_clothes)) return false;
/*  565 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  571 */     _xdb_verify_unsafe_();
/*  572 */     int _h_ = 0;
/*  573 */     _h_ += this.nextid;
/*  574 */     _h_ += this.curid;
/*  575 */     _h_ += this.defid;
/*  576 */     _h_ += this.maxcount;
/*  577 */     _h_ += this.clothes.hashCode();
/*  578 */     _h_ += this.fashion_dress_cloth_map.hashCode();
/*  579 */     _h_ += this.transfer_occupation_role_clothes.hashCode();
/*  580 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  586 */     _xdb_verify_unsafe_();
/*  587 */     StringBuilder _sb_ = new StringBuilder();
/*  588 */     _sb_.append("(");
/*  589 */     _sb_.append(this.nextid);
/*  590 */     _sb_.append(",");
/*  591 */     _sb_.append(this.curid);
/*  592 */     _sb_.append(",");
/*  593 */     _sb_.append(this.defid);
/*  594 */     _sb_.append(",");
/*  595 */     _sb_.append(this.maxcount);
/*  596 */     _sb_.append(",");
/*  597 */     _sb_.append(this.clothes);
/*  598 */     _sb_.append(",");
/*  599 */     _sb_.append(this.fashion_dress_cloth_map);
/*  600 */     _sb_.append(",");
/*  601 */     _sb_.append(this.transfer_occupation_role_clothes);
/*  602 */     _sb_.append(")");
/*  603 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  609 */     ListenableBean lb = new ListenableBean();
/*  610 */     lb.add(new ListenableChanged().setVarName("nextid"));
/*  611 */     lb.add(new ListenableChanged().setVarName("curid"));
/*  612 */     lb.add(new ListenableChanged().setVarName("defid"));
/*  613 */     lb.add(new ListenableChanged().setVarName("maxcount"));
/*  614 */     lb.add(new ListenableChanged().setVarName("clothes"));
/*  615 */     lb.add(new xdb.logs.ListenableMap().setVarName("fashion_dress_cloth_map"));
/*  616 */     lb.add(new xdb.logs.ListenableMap().setVarName("transfer_occupation_role_clothes"));
/*  617 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.RoleClothes {
/*      */     private Const() {}
/*      */     
/*      */     RoleClothes nThis() {
/*  624 */       return RoleClothes.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  630 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleClothes copy()
/*      */     {
/*  636 */       return RoleClothes.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleClothes toData()
/*      */     {
/*  642 */       return RoleClothes.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.RoleClothes toBean()
/*      */     {
/*  647 */       return RoleClothes.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleClothes toDataIf()
/*      */     {
/*  653 */       return RoleClothes.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.RoleClothes toBeanIf()
/*      */     {
/*  658 */       return RoleClothes.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getNextid()
/*      */     {
/*  665 */       RoleClothes.this._xdb_verify_unsafe_();
/*  666 */       return RoleClothes.this.nextid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurid()
/*      */     {
/*  673 */       RoleClothes.this._xdb_verify_unsafe_();
/*  674 */       return RoleClothes.this.curid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDefid()
/*      */     {
/*  681 */       RoleClothes.this._xdb_verify_unsafe_();
/*  682 */       return RoleClothes.this.defid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMaxcount()
/*      */     {
/*  689 */       RoleClothes.this._xdb_verify_unsafe_();
/*  690 */       return RoleClothes.this.maxcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.ClothColor> getClothes()
/*      */     {
/*  697 */       RoleClothes.this._xdb_verify_unsafe_();
/*  698 */       return xdb.Consts.constList(RoleClothes.this.clothes);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<xbean.ClothColor> getClothesAsData()
/*      */     {
/*  704 */       RoleClothes.this._xdb_verify_unsafe_();
/*      */       
/*  706 */       RoleClothes _o_ = RoleClothes.this;
/*  707 */       List<xbean.ClothColor> clothes = new ArrayList();
/*  708 */       for (xbean.ClothColor _v_ : _o_.clothes)
/*  709 */         clothes.add(new ClothColor.Data(_v_));
/*  710 */       return clothes;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getFashion_dress_cloth_map()
/*      */     {
/*  717 */       RoleClothes.this._xdb_verify_unsafe_();
/*  718 */       return xdb.Consts.constMap(RoleClothes.this.fashion_dress_cloth_map);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getFashion_dress_cloth_mapAsData()
/*      */     {
/*  725 */       RoleClothes.this._xdb_verify_unsafe_();
/*      */       
/*  727 */       RoleClothes _o_ = RoleClothes.this;
/*  728 */       Map<Integer, Integer> fashion_dress_cloth_map = new HashMap();
/*  729 */       for (Map.Entry<Integer, Integer> _e_ : _o_.fashion_dress_cloth_map.entrySet())
/*  730 */         fashion_dress_cloth_map.put(_e_.getKey(), _e_.getValue());
/*  731 */       return fashion_dress_cloth_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.TransferOccupationRoleClothes> getTransfer_occupation_role_clothes()
/*      */     {
/*  738 */       RoleClothes.this._xdb_verify_unsafe_();
/*  739 */       return xdb.Consts.constMap(RoleClothes.this.transfer_occupation_role_clothes);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.TransferOccupationRoleClothes> getTransfer_occupation_role_clothesAsData()
/*      */     {
/*  746 */       RoleClothes.this._xdb_verify_unsafe_();
/*      */       
/*  748 */       RoleClothes _o_ = RoleClothes.this;
/*  749 */       Map<Integer, xbean.TransferOccupationRoleClothes> transfer_occupation_role_clothes = new HashMap();
/*  750 */       for (Map.Entry<Integer, xbean.TransferOccupationRoleClothes> _e_ : _o_.transfer_occupation_role_clothes.entrySet())
/*  751 */         transfer_occupation_role_clothes.put(_e_.getKey(), new TransferOccupationRoleClothes.Data((xbean.TransferOccupationRoleClothes)_e_.getValue()));
/*  752 */       return transfer_occupation_role_clothes;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNextid(int _v_)
/*      */     {
/*  759 */       RoleClothes.this._xdb_verify_unsafe_();
/*  760 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurid(int _v_)
/*      */     {
/*  767 */       RoleClothes.this._xdb_verify_unsafe_();
/*  768 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDefid(int _v_)
/*      */     {
/*  775 */       RoleClothes.this._xdb_verify_unsafe_();
/*  776 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMaxcount(int _v_)
/*      */     {
/*  783 */       RoleClothes.this._xdb_verify_unsafe_();
/*  784 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  790 */       RoleClothes.this._xdb_verify_unsafe_();
/*  791 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  797 */       RoleClothes.this._xdb_verify_unsafe_();
/*  798 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  804 */       return RoleClothes.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  810 */       return RoleClothes.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  816 */       RoleClothes.this._xdb_verify_unsafe_();
/*  817 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  823 */       return RoleClothes.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  829 */       return RoleClothes.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  835 */       RoleClothes.this._xdb_verify_unsafe_();
/*  836 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  842 */       return RoleClothes.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  848 */       return RoleClothes.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  854 */       return RoleClothes.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  860 */       return RoleClothes.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  866 */       return RoleClothes.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  872 */       return RoleClothes.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  878 */       return RoleClothes.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.RoleClothes
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
/*      */     private HashMap<Integer, xbean.TransferOccupationRoleClothes> transfer_occupation_role_clothes;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  902 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  907 */       this.nextid = 0;
/*  908 */       this.curid = -1;
/*  909 */       this.defid = -1;
/*  910 */       this.maxcount = 10;
/*  911 */       this.clothes = new ArrayList();
/*  912 */       this.fashion_dress_cloth_map = new HashMap();
/*  913 */       this.transfer_occupation_role_clothes = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.RoleClothes _o1_)
/*      */     {
/*  918 */       if ((_o1_ instanceof RoleClothes)) { assign((RoleClothes)_o1_);
/*  919 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  920 */       } else if ((_o1_ instanceof RoleClothes.Const)) assign(((RoleClothes.Const)_o1_).nThis()); else {
/*  921 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(RoleClothes _o_) {
/*  926 */       this.nextid = _o_.nextid;
/*  927 */       this.curid = _o_.curid;
/*  928 */       this.defid = _o_.defid;
/*  929 */       this.maxcount = _o_.maxcount;
/*  930 */       this.clothes = new ArrayList();
/*  931 */       for (xbean.ClothColor _v_ : _o_.clothes)
/*  932 */         this.clothes.add(new ClothColor.Data(_v_));
/*  933 */       this.fashion_dress_cloth_map = new HashMap();
/*  934 */       for (Map.Entry<Integer, Integer> _e_ : _o_.fashion_dress_cloth_map.entrySet())
/*  935 */         this.fashion_dress_cloth_map.put(_e_.getKey(), _e_.getValue());
/*  936 */       this.transfer_occupation_role_clothes = new HashMap();
/*  937 */       for (Map.Entry<Integer, xbean.TransferOccupationRoleClothes> _e_ : _o_.transfer_occupation_role_clothes.entrySet()) {
/*  938 */         this.transfer_occupation_role_clothes.put(_e_.getKey(), new TransferOccupationRoleClothes.Data((xbean.TransferOccupationRoleClothes)_e_.getValue()));
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Data _o_) {
/*  943 */       this.nextid = _o_.nextid;
/*  944 */       this.curid = _o_.curid;
/*  945 */       this.defid = _o_.defid;
/*  946 */       this.maxcount = _o_.maxcount;
/*  947 */       this.clothes = new ArrayList();
/*  948 */       for (xbean.ClothColor _v_ : _o_.clothes)
/*  949 */         this.clothes.add(new ClothColor.Data(_v_));
/*  950 */       this.fashion_dress_cloth_map = new HashMap();
/*  951 */       for (Map.Entry<Integer, Integer> _e_ : _o_.fashion_dress_cloth_map.entrySet())
/*  952 */         this.fashion_dress_cloth_map.put(_e_.getKey(), _e_.getValue());
/*  953 */       this.transfer_occupation_role_clothes = new HashMap();
/*  954 */       for (Map.Entry<Integer, xbean.TransferOccupationRoleClothes> _e_ : _o_.transfer_occupation_role_clothes.entrySet()) {
/*  955 */         this.transfer_occupation_role_clothes.put(_e_.getKey(), new TransferOccupationRoleClothes.Data((xbean.TransferOccupationRoleClothes)_e_.getValue()));
/*      */       }
/*      */     }
/*      */     
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  961 */       _os_.marshal(this.nextid);
/*  962 */       _os_.marshal(this.curid);
/*  963 */       _os_.marshal(this.defid);
/*  964 */       _os_.marshal(this.maxcount);
/*  965 */       _os_.compact_uint32(this.clothes.size());
/*  966 */       for (xbean.ClothColor _v_ : this.clothes)
/*      */       {
/*  968 */         _v_.marshal(_os_);
/*      */       }
/*  970 */       _os_.compact_uint32(this.fashion_dress_cloth_map.size());
/*  971 */       for (Map.Entry<Integer, Integer> _e_ : this.fashion_dress_cloth_map.entrySet())
/*      */       {
/*  973 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  974 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/*  976 */       _os_.compact_uint32(this.transfer_occupation_role_clothes.size());
/*  977 */       for (Map.Entry<Integer, xbean.TransferOccupationRoleClothes> _e_ : this.transfer_occupation_role_clothes.entrySet())
/*      */       {
/*  979 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  980 */         ((xbean.TransferOccupationRoleClothes)_e_.getValue()).marshal(_os_);
/*      */       }
/*  982 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  988 */       this.nextid = _os_.unmarshal_int();
/*  989 */       this.curid = _os_.unmarshal_int();
/*  990 */       this.defid = _os_.unmarshal_int();
/*  991 */       this.maxcount = _os_.unmarshal_int();
/*  992 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  994 */         xbean.ClothColor _v_ = xbean.Pod.newClothColorData();
/*  995 */         _v_.unmarshal(_os_);
/*  996 */         this.clothes.add(_v_);
/*      */       }
/*      */       
/*  999 */       int size = _os_.uncompact_uint32();
/* 1000 */       if (size >= 12)
/*      */       {
/* 1002 */         this.fashion_dress_cloth_map = new HashMap(size * 2);
/*      */       }
/* 1004 */       for (; size > 0; size--)
/*      */       {
/* 1006 */         int _k_ = 0;
/* 1007 */         _k_ = _os_.unmarshal_int();
/* 1008 */         int _v_ = 0;
/* 1009 */         _v_ = _os_.unmarshal_int();
/* 1010 */         this.fashion_dress_cloth_map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*      */ 
/* 1014 */       int size = _os_.uncompact_uint32();
/* 1015 */       if (size >= 12)
/*      */       {
/* 1017 */         this.transfer_occupation_role_clothes = new HashMap(size * 2);
/*      */       }
/* 1019 */       for (; size > 0; size--)
/*      */       {
/* 1021 */         int _k_ = 0;
/* 1022 */         _k_ = _os_.unmarshal_int();
/* 1023 */         xbean.TransferOccupationRoleClothes _v_ = xbean.Pod.newTransferOccupationRoleClothesData();
/* 1024 */         _v_.unmarshal(_os_);
/* 1025 */         this.transfer_occupation_role_clothes.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/* 1028 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1034 */       int _size_ = 0;
/* 1035 */       _size_ += CodedOutputStream.computeInt32Size(1, this.nextid);
/* 1036 */       _size_ += CodedOutputStream.computeInt32Size(2, this.curid);
/* 1037 */       _size_ += CodedOutputStream.computeInt32Size(3, this.defid);
/* 1038 */       _size_ += CodedOutputStream.computeInt32Size(4, this.maxcount);
/* 1039 */       for (xbean.ClothColor _v_ : this.clothes)
/*      */       {
/* 1041 */         _size_ += CodedOutputStream.computeMessageSize(5, _v_);
/*      */       }
/* 1043 */       for (Map.Entry<Integer, Integer> _e_ : this.fashion_dress_cloth_map.entrySet())
/*      */       {
/* 1045 */         _size_ += CodedOutputStream.computeInt32Size(6, ((Integer)_e_.getKey()).intValue());
/* 1046 */         _size_ += CodedOutputStream.computeInt32Size(6, ((Integer)_e_.getValue()).intValue());
/*      */       }
/* 1048 */       for (Map.Entry<Integer, xbean.TransferOccupationRoleClothes> _e_ : this.transfer_occupation_role_clothes.entrySet())
/*      */       {
/* 1050 */         _size_ += CodedOutputStream.computeInt32Size(7, ((Integer)_e_.getKey()).intValue());
/* 1051 */         _size_ += CodedOutputStream.computeMessageSize(7, (ppbio.Message)_e_.getValue());
/*      */       }
/* 1053 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1061 */         _output_.writeInt32(1, this.nextid);
/* 1062 */         _output_.writeInt32(2, this.curid);
/* 1063 */         _output_.writeInt32(3, this.defid);
/* 1064 */         _output_.writeInt32(4, this.maxcount);
/* 1065 */         for (xbean.ClothColor _v_ : this.clothes)
/*      */         {
/* 1067 */           _output_.writeMessage(5, _v_);
/*      */         }
/* 1069 */         for (Map.Entry<Integer, Integer> _e_ : this.fashion_dress_cloth_map.entrySet())
/*      */         {
/* 1071 */           _output_.writeInt32(6, ((Integer)_e_.getKey()).intValue());
/* 1072 */           _output_.writeInt32(6, ((Integer)_e_.getValue()).intValue());
/*      */         }
/* 1074 */         for (Map.Entry<Integer, xbean.TransferOccupationRoleClothes> _e_ : this.transfer_occupation_role_clothes.entrySet())
/*      */         {
/* 1076 */           _output_.writeInt32(7, ((Integer)_e_.getKey()).intValue());
/* 1077 */           _output_.writeMessage(7, (ppbio.Message)_e_.getValue());
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1082 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1084 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1092 */         boolean done = false;
/* 1093 */         while (!done)
/*      */         {
/* 1095 */           int tag = _input_.readTag();
/* 1096 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1100 */             done = true;
/* 1101 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1105 */             this.nextid = _input_.readInt32();
/* 1106 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1110 */             this.curid = _input_.readInt32();
/* 1111 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1115 */             this.defid = _input_.readInt32();
/* 1116 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1120 */             this.maxcount = _input_.readInt32();
/* 1121 */             break;
/*      */           
/*      */ 
/*      */           case 42: 
/* 1125 */             xbean.ClothColor _v_ = xbean.Pod.newClothColorData();
/* 1126 */             _input_.readMessage(_v_);
/* 1127 */             this.clothes.add(_v_);
/* 1128 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1132 */             int _k_ = 0;
/* 1133 */             _k_ = _input_.readInt32();
/* 1134 */             int readTag = _input_.readTag();
/* 1135 */             if (48 != readTag)
/*      */             {
/* 1137 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1139 */             int _v_ = 0;
/* 1140 */             _v_ = _input_.readInt32();
/* 1141 */             this.fashion_dress_cloth_map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 1142 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1146 */             int _k_ = 0;
/* 1147 */             _k_ = _input_.readInt32();
/* 1148 */             int readTag = _input_.readTag();
/* 1149 */             if (58 != readTag)
/*      */             {
/* 1151 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1153 */             xbean.TransferOccupationRoleClothes _v_ = xbean.Pod.newTransferOccupationRoleClothesData();
/* 1154 */             _input_.readMessage(_v_);
/* 1155 */             this.transfer_occupation_role_clothes.put(Integer.valueOf(_k_), _v_);
/* 1156 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1160 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1162 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1171 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1175 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1177 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleClothes copy()
/*      */     {
/* 1183 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleClothes toData()
/*      */     {
/* 1189 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.RoleClothes toBean()
/*      */     {
/* 1194 */       return new RoleClothes(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleClothes toDataIf()
/*      */     {
/* 1200 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.RoleClothes toBeanIf()
/*      */     {
/* 1205 */       return new RoleClothes(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1211 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1215 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1219 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1223 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1227 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1231 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1235 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getNextid()
/*      */     {
/* 1242 */       return this.nextid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurid()
/*      */     {
/* 1249 */       return this.curid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDefid()
/*      */     {
/* 1256 */       return this.defid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMaxcount()
/*      */     {
/* 1263 */       return this.maxcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.ClothColor> getClothes()
/*      */     {
/* 1270 */       return this.clothes;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.ClothColor> getClothesAsData()
/*      */     {
/* 1277 */       return this.clothes;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getFashion_dress_cloth_map()
/*      */     {
/* 1284 */       return this.fashion_dress_cloth_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getFashion_dress_cloth_mapAsData()
/*      */     {
/* 1291 */       return this.fashion_dress_cloth_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.TransferOccupationRoleClothes> getTransfer_occupation_role_clothes()
/*      */     {
/* 1298 */       return this.transfer_occupation_role_clothes;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.TransferOccupationRoleClothes> getTransfer_occupation_role_clothesAsData()
/*      */     {
/* 1305 */       return this.transfer_occupation_role_clothes;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNextid(int _v_)
/*      */     {
/* 1312 */       this.nextid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurid(int _v_)
/*      */     {
/* 1319 */       this.curid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDefid(int _v_)
/*      */     {
/* 1326 */       this.defid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMaxcount(int _v_)
/*      */     {
/* 1333 */       this.maxcount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1339 */       if (!(_o1_ instanceof Data)) return false;
/* 1340 */       Data _o_ = (Data)_o1_;
/* 1341 */       if (this.nextid != _o_.nextid) return false;
/* 1342 */       if (this.curid != _o_.curid) return false;
/* 1343 */       if (this.defid != _o_.defid) return false;
/* 1344 */       if (this.maxcount != _o_.maxcount) return false;
/* 1345 */       if (!this.clothes.equals(_o_.clothes)) return false;
/* 1346 */       if (!this.fashion_dress_cloth_map.equals(_o_.fashion_dress_cloth_map)) return false;
/* 1347 */       if (!this.transfer_occupation_role_clothes.equals(_o_.transfer_occupation_role_clothes)) return false;
/* 1348 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1354 */       int _h_ = 0;
/* 1355 */       _h_ += this.nextid;
/* 1356 */       _h_ += this.curid;
/* 1357 */       _h_ += this.defid;
/* 1358 */       _h_ += this.maxcount;
/* 1359 */       _h_ += this.clothes.hashCode();
/* 1360 */       _h_ += this.fashion_dress_cloth_map.hashCode();
/* 1361 */       _h_ += this.transfer_occupation_role_clothes.hashCode();
/* 1362 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1368 */       StringBuilder _sb_ = new StringBuilder();
/* 1369 */       _sb_.append("(");
/* 1370 */       _sb_.append(this.nextid);
/* 1371 */       _sb_.append(",");
/* 1372 */       _sb_.append(this.curid);
/* 1373 */       _sb_.append(",");
/* 1374 */       _sb_.append(this.defid);
/* 1375 */       _sb_.append(",");
/* 1376 */       _sb_.append(this.maxcount);
/* 1377 */       _sb_.append(",");
/* 1378 */       _sb_.append(this.clothes);
/* 1379 */       _sb_.append(",");
/* 1380 */       _sb_.append(this.fashion_dress_cloth_map);
/* 1381 */       _sb_.append(",");
/* 1382 */       _sb_.append(this.transfer_occupation_role_clothes);
/* 1383 */       _sb_.append(")");
/* 1384 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RoleClothes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */