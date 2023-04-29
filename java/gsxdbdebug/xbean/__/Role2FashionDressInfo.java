/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.util.SetX;
/*      */ 
/*      */ public final class Role2FashionDressInfo extends XBean implements xbean.Role2FashionDressInfo
/*      */ {
/*      */   private int current_fashion_dress_cfg_id;
/*      */   private HashMap<Integer, xbean.FashionDressInfo> fashion_dress_map;
/*      */   private SetX<Integer> activate_property_set;
/*      */   private HashMap<Integer, xbean.TransferOccupationFashionDress> transfer_occupation_fashion_dress_map;
/*      */   private boolean new_year_fashion_dress_is_repaired;
/*      */   private SetX<Integer> own_unlock_theme_fashion_dress_type_set;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   28 */     this.current_fashion_dress_cfg_id = 0;
/*   29 */     this.fashion_dress_map.clear();
/*   30 */     this.activate_property_set.clear();
/*   31 */     this.transfer_occupation_fashion_dress_map.clear();
/*   32 */     this.new_year_fashion_dress_is_repaired = false;
/*   33 */     this.own_unlock_theme_fashion_dress_type_set.clear();
/*      */   }
/*      */   
/*      */   Role2FashionDressInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   38 */     super(_xp_, _vn_);
/*   39 */     this.fashion_dress_map = new HashMap();
/*   40 */     this.activate_property_set = new SetX();
/*   41 */     this.transfer_occupation_fashion_dress_map = new HashMap();
/*   42 */     this.new_year_fashion_dress_is_repaired = false;
/*   43 */     this.own_unlock_theme_fashion_dress_type_set = new SetX();
/*      */   }
/*      */   
/*      */   public Role2FashionDressInfo()
/*      */   {
/*   48 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public Role2FashionDressInfo(Role2FashionDressInfo _o_)
/*      */   {
/*   53 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   Role2FashionDressInfo(xbean.Role2FashionDressInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   58 */     super(_xp_, _vn_);
/*   59 */     if ((_o1_ instanceof Role2FashionDressInfo)) { assign((Role2FashionDressInfo)_o1_);
/*   60 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   61 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   62 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Role2FashionDressInfo _o_) {
/*   67 */     _o_._xdb_verify_unsafe_();
/*   68 */     this.current_fashion_dress_cfg_id = _o_.current_fashion_dress_cfg_id;
/*   69 */     this.fashion_dress_map = new HashMap();
/*   70 */     for (Map.Entry<Integer, xbean.FashionDressInfo> _e_ : _o_.fashion_dress_map.entrySet())
/*   71 */       this.fashion_dress_map.put(_e_.getKey(), new FashionDressInfo((xbean.FashionDressInfo)_e_.getValue(), this, "fashion_dress_map"));
/*   72 */     this.activate_property_set = new SetX();
/*   73 */     this.activate_property_set.addAll(_o_.activate_property_set);
/*   74 */     this.transfer_occupation_fashion_dress_map = new HashMap();
/*   75 */     for (Map.Entry<Integer, xbean.TransferOccupationFashionDress> _e_ : _o_.transfer_occupation_fashion_dress_map.entrySet())
/*   76 */       this.transfer_occupation_fashion_dress_map.put(_e_.getKey(), new TransferOccupationFashionDress((xbean.TransferOccupationFashionDress)_e_.getValue(), this, "transfer_occupation_fashion_dress_map"));
/*   77 */     this.new_year_fashion_dress_is_repaired = _o_.new_year_fashion_dress_is_repaired;
/*   78 */     this.own_unlock_theme_fashion_dress_type_set = new SetX();
/*   79 */     this.own_unlock_theme_fashion_dress_type_set.addAll(_o_.own_unlock_theme_fashion_dress_type_set);
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   84 */     this.current_fashion_dress_cfg_id = _o_.current_fashion_dress_cfg_id;
/*   85 */     this.fashion_dress_map = new HashMap();
/*   86 */     for (Map.Entry<Integer, xbean.FashionDressInfo> _e_ : _o_.fashion_dress_map.entrySet())
/*   87 */       this.fashion_dress_map.put(_e_.getKey(), new FashionDressInfo((xbean.FashionDressInfo)_e_.getValue(), this, "fashion_dress_map"));
/*   88 */     this.activate_property_set = new SetX();
/*   89 */     this.activate_property_set.addAll(_o_.activate_property_set);
/*   90 */     this.transfer_occupation_fashion_dress_map = new HashMap();
/*   91 */     for (Map.Entry<Integer, xbean.TransferOccupationFashionDress> _e_ : _o_.transfer_occupation_fashion_dress_map.entrySet())
/*   92 */       this.transfer_occupation_fashion_dress_map.put(_e_.getKey(), new TransferOccupationFashionDress((xbean.TransferOccupationFashionDress)_e_.getValue(), this, "transfer_occupation_fashion_dress_map"));
/*   93 */     this.new_year_fashion_dress_is_repaired = _o_.new_year_fashion_dress_is_repaired;
/*   94 */     this.own_unlock_theme_fashion_dress_type_set = new SetX();
/*   95 */     this.own_unlock_theme_fashion_dress_type_set.addAll(_o_.own_unlock_theme_fashion_dress_type_set);
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  101 */     _xdb_verify_unsafe_();
/*  102 */     _os_.marshal(this.current_fashion_dress_cfg_id);
/*  103 */     _os_.compact_uint32(this.fashion_dress_map.size());
/*  104 */     for (Map.Entry<Integer, xbean.FashionDressInfo> _e_ : this.fashion_dress_map.entrySet())
/*      */     {
/*  106 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  107 */       ((xbean.FashionDressInfo)_e_.getValue()).marshal(_os_);
/*      */     }
/*  109 */     _os_.compact_uint32(this.activate_property_set.size());
/*  110 */     for (Integer _v_ : this.activate_property_set)
/*      */     {
/*  112 */       _os_.marshal(_v_.intValue());
/*      */     }
/*  114 */     _os_.compact_uint32(this.transfer_occupation_fashion_dress_map.size());
/*  115 */     for (Map.Entry<Integer, xbean.TransferOccupationFashionDress> _e_ : this.transfer_occupation_fashion_dress_map.entrySet())
/*      */     {
/*  117 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  118 */       ((xbean.TransferOccupationFashionDress)_e_.getValue()).marshal(_os_);
/*      */     }
/*  120 */     _os_.marshal(this.new_year_fashion_dress_is_repaired);
/*  121 */     _os_.compact_uint32(this.own_unlock_theme_fashion_dress_type_set.size());
/*  122 */     for (Integer _v_ : this.own_unlock_theme_fashion_dress_type_set)
/*      */     {
/*  124 */       _os_.marshal(_v_.intValue());
/*      */     }
/*  126 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  132 */     _xdb_verify_unsafe_();
/*  133 */     this.current_fashion_dress_cfg_id = _os_.unmarshal_int();
/*      */     
/*  135 */     int size = _os_.uncompact_uint32();
/*  136 */     if (size >= 12)
/*      */     {
/*  138 */       this.fashion_dress_map = new HashMap(size * 2);
/*      */     }
/*  140 */     for (; size > 0; size--)
/*      */     {
/*  142 */       int _k_ = 0;
/*  143 */       _k_ = _os_.unmarshal_int();
/*  144 */       xbean.FashionDressInfo _v_ = new FashionDressInfo(0, this, "fashion_dress_map");
/*  145 */       _v_.unmarshal(_os_);
/*  146 */       this.fashion_dress_map.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  149 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  151 */       int _v_ = 0;
/*  152 */       _v_ = _os_.unmarshal_int();
/*  153 */       this.activate_property_set.add(Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  156 */     int size = _os_.uncompact_uint32();
/*  157 */     if (size >= 12)
/*      */     {
/*  159 */       this.transfer_occupation_fashion_dress_map = new HashMap(size * 2);
/*      */     }
/*  161 */     for (; size > 0; size--)
/*      */     {
/*  163 */       int _k_ = 0;
/*  164 */       _k_ = _os_.unmarshal_int();
/*  165 */       xbean.TransferOccupationFashionDress _v_ = new TransferOccupationFashionDress(0, this, "transfer_occupation_fashion_dress_map");
/*  166 */       _v_.unmarshal(_os_);
/*  167 */       this.transfer_occupation_fashion_dress_map.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  170 */     this.new_year_fashion_dress_is_repaired = _os_.unmarshal_boolean();
/*  171 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  173 */       int _v_ = 0;
/*  174 */       _v_ = _os_.unmarshal_int();
/*  175 */       this.own_unlock_theme_fashion_dress_type_set.add(Integer.valueOf(_v_));
/*      */     }
/*  177 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  183 */     _xdb_verify_unsafe_();
/*  184 */     int _size_ = 0;
/*  185 */     _size_ += CodedOutputStream.computeInt32Size(1, this.current_fashion_dress_cfg_id);
/*  186 */     for (Map.Entry<Integer, xbean.FashionDressInfo> _e_ : this.fashion_dress_map.entrySet())
/*      */     {
/*  188 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/*  189 */       _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*      */     }
/*  191 */     for (Integer _v_ : this.activate_property_set)
/*      */     {
/*  193 */       _size_ += CodedOutputStream.computeInt32Size(3, _v_.intValue());
/*      */     }
/*  195 */     for (Map.Entry<Integer, xbean.TransferOccupationFashionDress> _e_ : this.transfer_occupation_fashion_dress_map.entrySet())
/*      */     {
/*  197 */       _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getKey()).intValue());
/*  198 */       _size_ += CodedOutputStream.computeMessageSize(4, (ppbio.Message)_e_.getValue());
/*      */     }
/*  200 */     _size_ += CodedOutputStream.computeBoolSize(5, this.new_year_fashion_dress_is_repaired);
/*  201 */     for (Integer _v_ : this.own_unlock_theme_fashion_dress_type_set)
/*      */     {
/*  203 */       _size_ += CodedOutputStream.computeInt32Size(6, _v_.intValue());
/*      */     }
/*  205 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  211 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  214 */       _output_.writeInt32(1, this.current_fashion_dress_cfg_id);
/*  215 */       for (Map.Entry<Integer, xbean.FashionDressInfo> _e_ : this.fashion_dress_map.entrySet())
/*      */       {
/*  217 */         _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/*  218 */         _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*      */       }
/*  220 */       for (Integer _v_ : this.activate_property_set)
/*      */       {
/*  222 */         _output_.writeInt32(3, _v_.intValue());
/*      */       }
/*  224 */       for (Map.Entry<Integer, xbean.TransferOccupationFashionDress> _e_ : this.transfer_occupation_fashion_dress_map.entrySet())
/*      */       {
/*  226 */         _output_.writeInt32(4, ((Integer)_e_.getKey()).intValue());
/*  227 */         _output_.writeMessage(4, (ppbio.Message)_e_.getValue());
/*      */       }
/*  229 */       _output_.writeBool(5, this.new_year_fashion_dress_is_repaired);
/*  230 */       for (Integer _v_ : this.own_unlock_theme_fashion_dress_type_set)
/*      */       {
/*  232 */         _output_.writeInt32(6, _v_.intValue());
/*      */       }
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  237 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  239 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  245 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  248 */       boolean done = false;
/*  249 */       while (!done)
/*      */       {
/*  251 */         int tag = _input_.readTag();
/*  252 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  256 */           done = true;
/*  257 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  261 */           this.current_fashion_dress_cfg_id = _input_.readInt32();
/*  262 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  266 */           int _k_ = 0;
/*  267 */           _k_ = _input_.readInt32();
/*  268 */           int readTag = _input_.readTag();
/*  269 */           if (18 != readTag)
/*      */           {
/*  271 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  273 */           xbean.FashionDressInfo _v_ = new FashionDressInfo(0, this, "fashion_dress_map");
/*  274 */           _input_.readMessage(_v_);
/*  275 */           this.fashion_dress_map.put(Integer.valueOf(_k_), _v_);
/*  276 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  280 */           int _v_ = 0;
/*  281 */           _v_ = _input_.readInt32();
/*  282 */           this.activate_property_set.add(Integer.valueOf(_v_));
/*  283 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  287 */           int _k_ = 0;
/*  288 */           _k_ = _input_.readInt32();
/*  289 */           int readTag = _input_.readTag();
/*  290 */           if (34 != readTag)
/*      */           {
/*  292 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  294 */           xbean.TransferOccupationFashionDress _v_ = new TransferOccupationFashionDress(0, this, "transfer_occupation_fashion_dress_map");
/*  295 */           _input_.readMessage(_v_);
/*  296 */           this.transfer_occupation_fashion_dress_map.put(Integer.valueOf(_k_), _v_);
/*  297 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  301 */           this.new_year_fashion_dress_is_repaired = _input_.readBool();
/*  302 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  306 */           int _v_ = 0;
/*  307 */           _v_ = _input_.readInt32();
/*  308 */           this.own_unlock_theme_fashion_dress_type_set.add(Integer.valueOf(_v_));
/*  309 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  313 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  315 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  324 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  328 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  330 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Role2FashionDressInfo copy()
/*      */   {
/*  336 */     _xdb_verify_unsafe_();
/*  337 */     return new Role2FashionDressInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Role2FashionDressInfo toData()
/*      */   {
/*  343 */     _xdb_verify_unsafe_();
/*  344 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Role2FashionDressInfo toBean()
/*      */   {
/*  349 */     _xdb_verify_unsafe_();
/*  350 */     return new Role2FashionDressInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Role2FashionDressInfo toDataIf()
/*      */   {
/*  356 */     _xdb_verify_unsafe_();
/*  357 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Role2FashionDressInfo toBeanIf()
/*      */   {
/*  362 */     _xdb_verify_unsafe_();
/*  363 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  369 */     _xdb_verify_unsafe_();
/*  370 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCurrent_fashion_dress_cfg_id()
/*      */   {
/*  377 */     _xdb_verify_unsafe_();
/*  378 */     return this.current_fashion_dress_cfg_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.FashionDressInfo> getFashion_dress_map()
/*      */   {
/*  385 */     _xdb_verify_unsafe_();
/*  386 */     return xdb.Logs.logMap(new LogKey(this, "fashion_dress_map"), this.fashion_dress_map);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.FashionDressInfo> getFashion_dress_mapAsData()
/*      */   {
/*  393 */     _xdb_verify_unsafe_();
/*      */     
/*  395 */     Role2FashionDressInfo _o_ = this;
/*  396 */     Map<Integer, xbean.FashionDressInfo> fashion_dress_map = new HashMap();
/*  397 */     for (Map.Entry<Integer, xbean.FashionDressInfo> _e_ : _o_.fashion_dress_map.entrySet())
/*  398 */       fashion_dress_map.put(_e_.getKey(), new FashionDressInfo.Data((xbean.FashionDressInfo)_e_.getValue()));
/*  399 */     return fashion_dress_map;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Integer> getActivate_property_set()
/*      */   {
/*  406 */     _xdb_verify_unsafe_();
/*  407 */     return xdb.Logs.logSet(new LogKey(this, "activate_property_set"), this.activate_property_set);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Integer> getActivate_property_setAsData()
/*      */   {
/*  413 */     _xdb_verify_unsafe_();
/*      */     
/*  415 */     Role2FashionDressInfo _o_ = this;
/*  416 */     Set<Integer> activate_property_set = new SetX();
/*  417 */     activate_property_set.addAll(_o_.activate_property_set);
/*  418 */     return activate_property_set;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.TransferOccupationFashionDress> getTransfer_occupation_fashion_dress_map()
/*      */   {
/*  425 */     _xdb_verify_unsafe_();
/*  426 */     return xdb.Logs.logMap(new LogKey(this, "transfer_occupation_fashion_dress_map"), this.transfer_occupation_fashion_dress_map);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.TransferOccupationFashionDress> getTransfer_occupation_fashion_dress_mapAsData()
/*      */   {
/*  433 */     _xdb_verify_unsafe_();
/*      */     
/*  435 */     Role2FashionDressInfo _o_ = this;
/*  436 */     Map<Integer, xbean.TransferOccupationFashionDress> transfer_occupation_fashion_dress_map = new HashMap();
/*  437 */     for (Map.Entry<Integer, xbean.TransferOccupationFashionDress> _e_ : _o_.transfer_occupation_fashion_dress_map.entrySet())
/*  438 */       transfer_occupation_fashion_dress_map.put(_e_.getKey(), new TransferOccupationFashionDress.Data((xbean.TransferOccupationFashionDress)_e_.getValue()));
/*  439 */     return transfer_occupation_fashion_dress_map;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getNew_year_fashion_dress_is_repaired()
/*      */   {
/*  446 */     _xdb_verify_unsafe_();
/*  447 */     return this.new_year_fashion_dress_is_repaired;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Integer> getOwn_unlock_theme_fashion_dress_type_set()
/*      */   {
/*  454 */     _xdb_verify_unsafe_();
/*  455 */     return xdb.Logs.logSet(new LogKey(this, "own_unlock_theme_fashion_dress_type_set"), this.own_unlock_theme_fashion_dress_type_set);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Integer> getOwn_unlock_theme_fashion_dress_type_setAsData()
/*      */   {
/*  461 */     _xdb_verify_unsafe_();
/*      */     
/*  463 */     Role2FashionDressInfo _o_ = this;
/*  464 */     Set<Integer> own_unlock_theme_fashion_dress_type_set = new SetX();
/*  465 */     own_unlock_theme_fashion_dress_type_set.addAll(_o_.own_unlock_theme_fashion_dress_type_set);
/*  466 */     return own_unlock_theme_fashion_dress_type_set;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCurrent_fashion_dress_cfg_id(int _v_)
/*      */   {
/*  473 */     _xdb_verify_unsafe_();
/*  474 */     xdb.Logs.logIf(new LogKey(this, "current_fashion_dress_cfg_id")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  478 */         new xdb.logs.LogInt(this, Role2FashionDressInfo.this.current_fashion_dress_cfg_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  482 */             Role2FashionDressInfo.this.current_fashion_dress_cfg_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  486 */     });
/*  487 */     this.current_fashion_dress_cfg_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setNew_year_fashion_dress_is_repaired(boolean _v_)
/*      */   {
/*  494 */     _xdb_verify_unsafe_();
/*  495 */     xdb.Logs.logIf(new LogKey(this, "new_year_fashion_dress_is_repaired")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  499 */         new xdb.logs.LogObject(this, Boolean.valueOf(Role2FashionDressInfo.this.new_year_fashion_dress_is_repaired))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  503 */             Role2FashionDressInfo.this.new_year_fashion_dress_is_repaired = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  507 */     });
/*  508 */     this.new_year_fashion_dress_is_repaired = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  514 */     _xdb_verify_unsafe_();
/*  515 */     Role2FashionDressInfo _o_ = null;
/*  516 */     if ((_o1_ instanceof Role2FashionDressInfo)) { _o_ = (Role2FashionDressInfo)_o1_;
/*  517 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  518 */       return false;
/*  519 */     if (this.current_fashion_dress_cfg_id != _o_.current_fashion_dress_cfg_id) return false;
/*  520 */     if (!this.fashion_dress_map.equals(_o_.fashion_dress_map)) return false;
/*  521 */     if (!this.activate_property_set.equals(_o_.activate_property_set)) return false;
/*  522 */     if (!this.transfer_occupation_fashion_dress_map.equals(_o_.transfer_occupation_fashion_dress_map)) return false;
/*  523 */     if (this.new_year_fashion_dress_is_repaired != _o_.new_year_fashion_dress_is_repaired) return false;
/*  524 */     if (!this.own_unlock_theme_fashion_dress_type_set.equals(_o_.own_unlock_theme_fashion_dress_type_set)) return false;
/*  525 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  531 */     _xdb_verify_unsafe_();
/*  532 */     int _h_ = 0;
/*  533 */     _h_ += this.current_fashion_dress_cfg_id;
/*  534 */     _h_ += this.fashion_dress_map.hashCode();
/*  535 */     _h_ += this.activate_property_set.hashCode();
/*  536 */     _h_ += this.transfer_occupation_fashion_dress_map.hashCode();
/*  537 */     _h_ += (this.new_year_fashion_dress_is_repaired ? 1231 : 1237);
/*  538 */     _h_ += this.own_unlock_theme_fashion_dress_type_set.hashCode();
/*  539 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  545 */     _xdb_verify_unsafe_();
/*  546 */     StringBuilder _sb_ = new StringBuilder();
/*  547 */     _sb_.append("(");
/*  548 */     _sb_.append(this.current_fashion_dress_cfg_id);
/*  549 */     _sb_.append(",");
/*  550 */     _sb_.append(this.fashion_dress_map);
/*  551 */     _sb_.append(",");
/*  552 */     _sb_.append(this.activate_property_set);
/*  553 */     _sb_.append(",");
/*  554 */     _sb_.append(this.transfer_occupation_fashion_dress_map);
/*  555 */     _sb_.append(",");
/*  556 */     _sb_.append(this.new_year_fashion_dress_is_repaired);
/*  557 */     _sb_.append(",");
/*  558 */     _sb_.append(this.own_unlock_theme_fashion_dress_type_set);
/*  559 */     _sb_.append(")");
/*  560 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  566 */     ListenableBean lb = new ListenableBean();
/*  567 */     lb.add(new xdb.logs.ListenableChanged().setVarName("current_fashion_dress_cfg_id"));
/*  568 */     lb.add(new xdb.logs.ListenableMap().setVarName("fashion_dress_map"));
/*  569 */     lb.add(new xdb.logs.ListenableSet().setVarName("activate_property_set"));
/*  570 */     lb.add(new xdb.logs.ListenableMap().setVarName("transfer_occupation_fashion_dress_map"));
/*  571 */     lb.add(new xdb.logs.ListenableChanged().setVarName("new_year_fashion_dress_is_repaired"));
/*  572 */     lb.add(new xdb.logs.ListenableSet().setVarName("own_unlock_theme_fashion_dress_type_set"));
/*  573 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.Role2FashionDressInfo {
/*      */     private Const() {}
/*      */     
/*      */     Role2FashionDressInfo nThis() {
/*  580 */       return Role2FashionDressInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  586 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2FashionDressInfo copy()
/*      */     {
/*  592 */       return Role2FashionDressInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2FashionDressInfo toData()
/*      */     {
/*  598 */       return Role2FashionDressInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.Role2FashionDressInfo toBean()
/*      */     {
/*  603 */       return Role2FashionDressInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2FashionDressInfo toDataIf()
/*      */     {
/*  609 */       return Role2FashionDressInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.Role2FashionDressInfo toBeanIf()
/*      */     {
/*  614 */       return Role2FashionDressInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurrent_fashion_dress_cfg_id()
/*      */     {
/*  621 */       Role2FashionDressInfo.this._xdb_verify_unsafe_();
/*  622 */       return Role2FashionDressInfo.this.current_fashion_dress_cfg_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.FashionDressInfo> getFashion_dress_map()
/*      */     {
/*  629 */       Role2FashionDressInfo.this._xdb_verify_unsafe_();
/*  630 */       return xdb.Consts.constMap(Role2FashionDressInfo.this.fashion_dress_map);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.FashionDressInfo> getFashion_dress_mapAsData()
/*      */     {
/*  637 */       Role2FashionDressInfo.this._xdb_verify_unsafe_();
/*      */       
/*  639 */       Role2FashionDressInfo _o_ = Role2FashionDressInfo.this;
/*  640 */       Map<Integer, xbean.FashionDressInfo> fashion_dress_map = new HashMap();
/*  641 */       for (Map.Entry<Integer, xbean.FashionDressInfo> _e_ : _o_.fashion_dress_map.entrySet())
/*  642 */         fashion_dress_map.put(_e_.getKey(), new FashionDressInfo.Data((xbean.FashionDressInfo)_e_.getValue()));
/*  643 */       return fashion_dress_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getActivate_property_set()
/*      */     {
/*  650 */       Role2FashionDressInfo.this._xdb_verify_unsafe_();
/*  651 */       return xdb.Consts.constSet(Role2FashionDressInfo.this.activate_property_set);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Integer> getActivate_property_setAsData()
/*      */     {
/*  657 */       Role2FashionDressInfo.this._xdb_verify_unsafe_();
/*      */       
/*  659 */       Role2FashionDressInfo _o_ = Role2FashionDressInfo.this;
/*  660 */       Set<Integer> activate_property_set = new SetX();
/*  661 */       activate_property_set.addAll(_o_.activate_property_set);
/*  662 */       return activate_property_set;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.TransferOccupationFashionDress> getTransfer_occupation_fashion_dress_map()
/*      */     {
/*  669 */       Role2FashionDressInfo.this._xdb_verify_unsafe_();
/*  670 */       return xdb.Consts.constMap(Role2FashionDressInfo.this.transfer_occupation_fashion_dress_map);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.TransferOccupationFashionDress> getTransfer_occupation_fashion_dress_mapAsData()
/*      */     {
/*  677 */       Role2FashionDressInfo.this._xdb_verify_unsafe_();
/*      */       
/*  679 */       Role2FashionDressInfo _o_ = Role2FashionDressInfo.this;
/*  680 */       Map<Integer, xbean.TransferOccupationFashionDress> transfer_occupation_fashion_dress_map = new HashMap();
/*  681 */       for (Map.Entry<Integer, xbean.TransferOccupationFashionDress> _e_ : _o_.transfer_occupation_fashion_dress_map.entrySet())
/*  682 */         transfer_occupation_fashion_dress_map.put(_e_.getKey(), new TransferOccupationFashionDress.Data((xbean.TransferOccupationFashionDress)_e_.getValue()));
/*  683 */       return transfer_occupation_fashion_dress_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getNew_year_fashion_dress_is_repaired()
/*      */     {
/*  690 */       Role2FashionDressInfo.this._xdb_verify_unsafe_();
/*  691 */       return Role2FashionDressInfo.this.new_year_fashion_dress_is_repaired;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getOwn_unlock_theme_fashion_dress_type_set()
/*      */     {
/*  698 */       Role2FashionDressInfo.this._xdb_verify_unsafe_();
/*  699 */       return xdb.Consts.constSet(Role2FashionDressInfo.this.own_unlock_theme_fashion_dress_type_set);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Integer> getOwn_unlock_theme_fashion_dress_type_setAsData()
/*      */     {
/*  705 */       Role2FashionDressInfo.this._xdb_verify_unsafe_();
/*      */       
/*  707 */       Role2FashionDressInfo _o_ = Role2FashionDressInfo.this;
/*  708 */       Set<Integer> own_unlock_theme_fashion_dress_type_set = new SetX();
/*  709 */       own_unlock_theme_fashion_dress_type_set.addAll(_o_.own_unlock_theme_fashion_dress_type_set);
/*  710 */       return own_unlock_theme_fashion_dress_type_set;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrent_fashion_dress_cfg_id(int _v_)
/*      */     {
/*  717 */       Role2FashionDressInfo.this._xdb_verify_unsafe_();
/*  718 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNew_year_fashion_dress_is_repaired(boolean _v_)
/*      */     {
/*  725 */       Role2FashionDressInfo.this._xdb_verify_unsafe_();
/*  726 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  732 */       Role2FashionDressInfo.this._xdb_verify_unsafe_();
/*  733 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  739 */       Role2FashionDressInfo.this._xdb_verify_unsafe_();
/*  740 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  746 */       return Role2FashionDressInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  752 */       return Role2FashionDressInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  758 */       Role2FashionDressInfo.this._xdb_verify_unsafe_();
/*  759 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  765 */       return Role2FashionDressInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  771 */       return Role2FashionDressInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  777 */       Role2FashionDressInfo.this._xdb_verify_unsafe_();
/*  778 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  784 */       return Role2FashionDressInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  790 */       return Role2FashionDressInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  796 */       return Role2FashionDressInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  802 */       return Role2FashionDressInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  808 */       return Role2FashionDressInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  814 */       return Role2FashionDressInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  820 */       return Role2FashionDressInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.Role2FashionDressInfo
/*      */   {
/*      */     private int current_fashion_dress_cfg_id;
/*      */     
/*      */     private HashMap<Integer, xbean.FashionDressInfo> fashion_dress_map;
/*      */     
/*      */     private HashSet<Integer> activate_property_set;
/*      */     
/*      */     private HashMap<Integer, xbean.TransferOccupationFashionDress> transfer_occupation_fashion_dress_map;
/*      */     
/*      */     private boolean new_year_fashion_dress_is_repaired;
/*      */     
/*      */     private HashSet<Integer> own_unlock_theme_fashion_dress_type_set;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  842 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  847 */       this.fashion_dress_map = new HashMap();
/*  848 */       this.activate_property_set = new HashSet();
/*  849 */       this.transfer_occupation_fashion_dress_map = new HashMap();
/*  850 */       this.new_year_fashion_dress_is_repaired = false;
/*  851 */       this.own_unlock_theme_fashion_dress_type_set = new HashSet();
/*      */     }
/*      */     
/*      */     Data(xbean.Role2FashionDressInfo _o1_)
/*      */     {
/*  856 */       if ((_o1_ instanceof Role2FashionDressInfo)) { assign((Role2FashionDressInfo)_o1_);
/*  857 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  858 */       } else if ((_o1_ instanceof Role2FashionDressInfo.Const)) assign(((Role2FashionDressInfo.Const)_o1_).nThis()); else {
/*  859 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Role2FashionDressInfo _o_) {
/*  864 */       this.current_fashion_dress_cfg_id = _o_.current_fashion_dress_cfg_id;
/*  865 */       this.fashion_dress_map = new HashMap();
/*  866 */       for (Map.Entry<Integer, xbean.FashionDressInfo> _e_ : _o_.fashion_dress_map.entrySet())
/*  867 */         this.fashion_dress_map.put(_e_.getKey(), new FashionDressInfo.Data((xbean.FashionDressInfo)_e_.getValue()));
/*  868 */       this.activate_property_set = new HashSet();
/*  869 */       this.activate_property_set.addAll(_o_.activate_property_set);
/*  870 */       this.transfer_occupation_fashion_dress_map = new HashMap();
/*  871 */       for (Map.Entry<Integer, xbean.TransferOccupationFashionDress> _e_ : _o_.transfer_occupation_fashion_dress_map.entrySet())
/*  872 */         this.transfer_occupation_fashion_dress_map.put(_e_.getKey(), new TransferOccupationFashionDress.Data((xbean.TransferOccupationFashionDress)_e_.getValue()));
/*  873 */       this.new_year_fashion_dress_is_repaired = _o_.new_year_fashion_dress_is_repaired;
/*  874 */       this.own_unlock_theme_fashion_dress_type_set = new HashSet();
/*  875 */       this.own_unlock_theme_fashion_dress_type_set.addAll(_o_.own_unlock_theme_fashion_dress_type_set);
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  880 */       this.current_fashion_dress_cfg_id = _o_.current_fashion_dress_cfg_id;
/*  881 */       this.fashion_dress_map = new HashMap();
/*  882 */       for (Map.Entry<Integer, xbean.FashionDressInfo> _e_ : _o_.fashion_dress_map.entrySet())
/*  883 */         this.fashion_dress_map.put(_e_.getKey(), new FashionDressInfo.Data((xbean.FashionDressInfo)_e_.getValue()));
/*  884 */       this.activate_property_set = new HashSet();
/*  885 */       this.activate_property_set.addAll(_o_.activate_property_set);
/*  886 */       this.transfer_occupation_fashion_dress_map = new HashMap();
/*  887 */       for (Map.Entry<Integer, xbean.TransferOccupationFashionDress> _e_ : _o_.transfer_occupation_fashion_dress_map.entrySet())
/*  888 */         this.transfer_occupation_fashion_dress_map.put(_e_.getKey(), new TransferOccupationFashionDress.Data((xbean.TransferOccupationFashionDress)_e_.getValue()));
/*  889 */       this.new_year_fashion_dress_is_repaired = _o_.new_year_fashion_dress_is_repaired;
/*  890 */       this.own_unlock_theme_fashion_dress_type_set = new HashSet();
/*  891 */       this.own_unlock_theme_fashion_dress_type_set.addAll(_o_.own_unlock_theme_fashion_dress_type_set);
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  897 */       _os_.marshal(this.current_fashion_dress_cfg_id);
/*  898 */       _os_.compact_uint32(this.fashion_dress_map.size());
/*  899 */       for (Map.Entry<Integer, xbean.FashionDressInfo> _e_ : this.fashion_dress_map.entrySet())
/*      */       {
/*  901 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  902 */         ((xbean.FashionDressInfo)_e_.getValue()).marshal(_os_);
/*      */       }
/*  904 */       _os_.compact_uint32(this.activate_property_set.size());
/*  905 */       for (Integer _v_ : this.activate_property_set)
/*      */       {
/*  907 */         _os_.marshal(_v_.intValue());
/*      */       }
/*  909 */       _os_.compact_uint32(this.transfer_occupation_fashion_dress_map.size());
/*  910 */       for (Map.Entry<Integer, xbean.TransferOccupationFashionDress> _e_ : this.transfer_occupation_fashion_dress_map.entrySet())
/*      */       {
/*  912 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  913 */         ((xbean.TransferOccupationFashionDress)_e_.getValue()).marshal(_os_);
/*      */       }
/*  915 */       _os_.marshal(this.new_year_fashion_dress_is_repaired);
/*  916 */       _os_.compact_uint32(this.own_unlock_theme_fashion_dress_type_set.size());
/*  917 */       for (Integer _v_ : this.own_unlock_theme_fashion_dress_type_set)
/*      */       {
/*  919 */         _os_.marshal(_v_.intValue());
/*      */       }
/*  921 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  927 */       this.current_fashion_dress_cfg_id = _os_.unmarshal_int();
/*      */       
/*  929 */       int size = _os_.uncompact_uint32();
/*  930 */       if (size >= 12)
/*      */       {
/*  932 */         this.fashion_dress_map = new HashMap(size * 2);
/*      */       }
/*  934 */       for (; size > 0; size--)
/*      */       {
/*  936 */         int _k_ = 0;
/*  937 */         _k_ = _os_.unmarshal_int();
/*  938 */         xbean.FashionDressInfo _v_ = xbean.Pod.newFashionDressInfoData();
/*  939 */         _v_.unmarshal(_os_);
/*  940 */         this.fashion_dress_map.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*  943 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  945 */         int _v_ = 0;
/*  946 */         _v_ = _os_.unmarshal_int();
/*  947 */         this.activate_property_set.add(Integer.valueOf(_v_));
/*      */       }
/*      */       
/*  950 */       int size = _os_.uncompact_uint32();
/*  951 */       if (size >= 12)
/*      */       {
/*  953 */         this.transfer_occupation_fashion_dress_map = new HashMap(size * 2);
/*      */       }
/*  955 */       for (; size > 0; size--)
/*      */       {
/*  957 */         int _k_ = 0;
/*  958 */         _k_ = _os_.unmarshal_int();
/*  959 */         xbean.TransferOccupationFashionDress _v_ = xbean.Pod.newTransferOccupationFashionDressData();
/*  960 */         _v_.unmarshal(_os_);
/*  961 */         this.transfer_occupation_fashion_dress_map.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*  964 */       this.new_year_fashion_dress_is_repaired = _os_.unmarshal_boolean();
/*  965 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  967 */         int _v_ = 0;
/*  968 */         _v_ = _os_.unmarshal_int();
/*  969 */         this.own_unlock_theme_fashion_dress_type_set.add(Integer.valueOf(_v_));
/*      */       }
/*  971 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  977 */       int _size_ = 0;
/*  978 */       _size_ += CodedOutputStream.computeInt32Size(1, this.current_fashion_dress_cfg_id);
/*  979 */       for (Map.Entry<Integer, xbean.FashionDressInfo> _e_ : this.fashion_dress_map.entrySet())
/*      */       {
/*  981 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/*  982 */         _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*      */       }
/*  984 */       for (Integer _v_ : this.activate_property_set)
/*      */       {
/*  986 */         _size_ += CodedOutputStream.computeInt32Size(3, _v_.intValue());
/*      */       }
/*  988 */       for (Map.Entry<Integer, xbean.TransferOccupationFashionDress> _e_ : this.transfer_occupation_fashion_dress_map.entrySet())
/*      */       {
/*  990 */         _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getKey()).intValue());
/*  991 */         _size_ += CodedOutputStream.computeMessageSize(4, (ppbio.Message)_e_.getValue());
/*      */       }
/*  993 */       _size_ += CodedOutputStream.computeBoolSize(5, this.new_year_fashion_dress_is_repaired);
/*  994 */       for (Integer _v_ : this.own_unlock_theme_fashion_dress_type_set)
/*      */       {
/*  996 */         _size_ += CodedOutputStream.computeInt32Size(6, _v_.intValue());
/*      */       }
/*  998 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1006 */         _output_.writeInt32(1, this.current_fashion_dress_cfg_id);
/* 1007 */         for (Map.Entry<Integer, xbean.FashionDressInfo> _e_ : this.fashion_dress_map.entrySet())
/*      */         {
/* 1009 */           _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/* 1010 */           _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*      */         }
/* 1012 */         for (Integer _v_ : this.activate_property_set)
/*      */         {
/* 1014 */           _output_.writeInt32(3, _v_.intValue());
/*      */         }
/* 1016 */         for (Map.Entry<Integer, xbean.TransferOccupationFashionDress> _e_ : this.transfer_occupation_fashion_dress_map.entrySet())
/*      */         {
/* 1018 */           _output_.writeInt32(4, ((Integer)_e_.getKey()).intValue());
/* 1019 */           _output_.writeMessage(4, (ppbio.Message)_e_.getValue());
/*      */         }
/* 1021 */         _output_.writeBool(5, this.new_year_fashion_dress_is_repaired);
/* 1022 */         for (Integer _v_ : this.own_unlock_theme_fashion_dress_type_set)
/*      */         {
/* 1024 */           _output_.writeInt32(6, _v_.intValue());
/*      */         }
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/* 1029 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1031 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1039 */         boolean done = false;
/* 1040 */         while (!done)
/*      */         {
/* 1042 */           int tag = _input_.readTag();
/* 1043 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1047 */             done = true;
/* 1048 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1052 */             this.current_fashion_dress_cfg_id = _input_.readInt32();
/* 1053 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1057 */             int _k_ = 0;
/* 1058 */             _k_ = _input_.readInt32();
/* 1059 */             int readTag = _input_.readTag();
/* 1060 */             if (18 != readTag)
/*      */             {
/* 1062 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1064 */             xbean.FashionDressInfo _v_ = xbean.Pod.newFashionDressInfoData();
/* 1065 */             _input_.readMessage(_v_);
/* 1066 */             this.fashion_dress_map.put(Integer.valueOf(_k_), _v_);
/* 1067 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1071 */             int _v_ = 0;
/* 1072 */             _v_ = _input_.readInt32();
/* 1073 */             this.activate_property_set.add(Integer.valueOf(_v_));
/* 1074 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1078 */             int _k_ = 0;
/* 1079 */             _k_ = _input_.readInt32();
/* 1080 */             int readTag = _input_.readTag();
/* 1081 */             if (34 != readTag)
/*      */             {
/* 1083 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1085 */             xbean.TransferOccupationFashionDress _v_ = xbean.Pod.newTransferOccupationFashionDressData();
/* 1086 */             _input_.readMessage(_v_);
/* 1087 */             this.transfer_occupation_fashion_dress_map.put(Integer.valueOf(_k_), _v_);
/* 1088 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1092 */             this.new_year_fashion_dress_is_repaired = _input_.readBool();
/* 1093 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1097 */             int _v_ = 0;
/* 1098 */             _v_ = _input_.readInt32();
/* 1099 */             this.own_unlock_theme_fashion_dress_type_set.add(Integer.valueOf(_v_));
/* 1100 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1104 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1106 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1115 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/* 1119 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1121 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2FashionDressInfo copy()
/*      */     {
/* 1127 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2FashionDressInfo toData()
/*      */     {
/* 1133 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.Role2FashionDressInfo toBean()
/*      */     {
/* 1138 */       return new Role2FashionDressInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2FashionDressInfo toDataIf()
/*      */     {
/* 1144 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.Role2FashionDressInfo toBeanIf()
/*      */     {
/* 1149 */       return new Role2FashionDressInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1155 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1159 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1163 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1167 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1171 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1175 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1179 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurrent_fashion_dress_cfg_id()
/*      */     {
/* 1186 */       return this.current_fashion_dress_cfg_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.FashionDressInfo> getFashion_dress_map()
/*      */     {
/* 1193 */       return this.fashion_dress_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.FashionDressInfo> getFashion_dress_mapAsData()
/*      */     {
/* 1200 */       return this.fashion_dress_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getActivate_property_set()
/*      */     {
/* 1207 */       return this.activate_property_set;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getActivate_property_setAsData()
/*      */     {
/* 1214 */       return this.activate_property_set;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.TransferOccupationFashionDress> getTransfer_occupation_fashion_dress_map()
/*      */     {
/* 1221 */       return this.transfer_occupation_fashion_dress_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.TransferOccupationFashionDress> getTransfer_occupation_fashion_dress_mapAsData()
/*      */     {
/* 1228 */       return this.transfer_occupation_fashion_dress_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getNew_year_fashion_dress_is_repaired()
/*      */     {
/* 1235 */       return this.new_year_fashion_dress_is_repaired;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getOwn_unlock_theme_fashion_dress_type_set()
/*      */     {
/* 1242 */       return this.own_unlock_theme_fashion_dress_type_set;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getOwn_unlock_theme_fashion_dress_type_setAsData()
/*      */     {
/* 1249 */       return this.own_unlock_theme_fashion_dress_type_set;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrent_fashion_dress_cfg_id(int _v_)
/*      */     {
/* 1256 */       this.current_fashion_dress_cfg_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNew_year_fashion_dress_is_repaired(boolean _v_)
/*      */     {
/* 1263 */       this.new_year_fashion_dress_is_repaired = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1269 */       if (!(_o1_ instanceof Data)) return false;
/* 1270 */       Data _o_ = (Data)_o1_;
/* 1271 */       if (this.current_fashion_dress_cfg_id != _o_.current_fashion_dress_cfg_id) return false;
/* 1272 */       if (!this.fashion_dress_map.equals(_o_.fashion_dress_map)) return false;
/* 1273 */       if (!this.activate_property_set.equals(_o_.activate_property_set)) return false;
/* 1274 */       if (!this.transfer_occupation_fashion_dress_map.equals(_o_.transfer_occupation_fashion_dress_map)) return false;
/* 1275 */       if (this.new_year_fashion_dress_is_repaired != _o_.new_year_fashion_dress_is_repaired) return false;
/* 1276 */       if (!this.own_unlock_theme_fashion_dress_type_set.equals(_o_.own_unlock_theme_fashion_dress_type_set)) return false;
/* 1277 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1283 */       int _h_ = 0;
/* 1284 */       _h_ += this.current_fashion_dress_cfg_id;
/* 1285 */       _h_ += this.fashion_dress_map.hashCode();
/* 1286 */       _h_ += this.activate_property_set.hashCode();
/* 1287 */       _h_ += this.transfer_occupation_fashion_dress_map.hashCode();
/* 1288 */       _h_ += (this.new_year_fashion_dress_is_repaired ? 1231 : 1237);
/* 1289 */       _h_ += this.own_unlock_theme_fashion_dress_type_set.hashCode();
/* 1290 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1296 */       StringBuilder _sb_ = new StringBuilder();
/* 1297 */       _sb_.append("(");
/* 1298 */       _sb_.append(this.current_fashion_dress_cfg_id);
/* 1299 */       _sb_.append(",");
/* 1300 */       _sb_.append(this.fashion_dress_map);
/* 1301 */       _sb_.append(",");
/* 1302 */       _sb_.append(this.activate_property_set);
/* 1303 */       _sb_.append(",");
/* 1304 */       _sb_.append(this.transfer_occupation_fashion_dress_map);
/* 1305 */       _sb_.append(",");
/* 1306 */       _sb_.append(this.new_year_fashion_dress_is_repaired);
/* 1307 */       _sb_.append(",");
/* 1308 */       _sb_.append(this.own_unlock_theme_fashion_dress_type_set);
/* 1309 */       _sb_.append(")");
/* 1310 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Role2FashionDressInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */