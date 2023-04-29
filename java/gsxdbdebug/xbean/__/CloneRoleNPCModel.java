/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import ppbio.ByteString;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableMap;
/*      */ 
/*      */ public final class CloneRoleNPCModel extends XBean implements xbean.CloneRoleNPCModel
/*      */ {
/*      */   private long roleid;
/*      */   private HashMap<Integer, String> string_prop_map;
/*      */   private HashMap<Integer, Integer> int_prop_map;
/*      */   private int modelid;
/*      */   private int colorid;
/*      */   private HashMap<Integer, Integer> model_info;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   28 */     this.roleid = 0L;
/*   29 */     this.string_prop_map.clear();
/*   30 */     this.int_prop_map.clear();
/*   31 */     this.modelid = 0;
/*   32 */     this.colorid = 0;
/*   33 */     this.model_info.clear();
/*      */   }
/*      */   
/*      */   CloneRoleNPCModel(int __, XBean _xp_, String _vn_)
/*      */   {
/*   38 */     super(_xp_, _vn_);
/*   39 */     this.string_prop_map = new HashMap();
/*   40 */     this.int_prop_map = new HashMap();
/*   41 */     this.model_info = new HashMap();
/*      */   }
/*      */   
/*      */   public CloneRoleNPCModel()
/*      */   {
/*   46 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public CloneRoleNPCModel(CloneRoleNPCModel _o_)
/*      */   {
/*   51 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   CloneRoleNPCModel(xbean.CloneRoleNPCModel _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   56 */     super(_xp_, _vn_);
/*   57 */     if ((_o1_ instanceof CloneRoleNPCModel)) { assign((CloneRoleNPCModel)_o1_);
/*   58 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   59 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   60 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(CloneRoleNPCModel _o_) {
/*   65 */     _o_._xdb_verify_unsafe_();
/*   66 */     this.roleid = _o_.roleid;
/*   67 */     this.string_prop_map = new HashMap();
/*   68 */     for (Map.Entry<Integer, String> _e_ : _o_.string_prop_map.entrySet())
/*   69 */       this.string_prop_map.put(_e_.getKey(), _e_.getValue());
/*   70 */     this.int_prop_map = new HashMap();
/*   71 */     for (Map.Entry<Integer, Integer> _e_ : _o_.int_prop_map.entrySet())
/*   72 */       this.int_prop_map.put(_e_.getKey(), _e_.getValue());
/*   73 */     this.modelid = _o_.modelid;
/*   74 */     this.colorid = _o_.colorid;
/*   75 */     this.model_info = new HashMap();
/*   76 */     for (Map.Entry<Integer, Integer> _e_ : _o_.model_info.entrySet()) {
/*   77 */       this.model_info.put(_e_.getKey(), _e_.getValue());
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Data _o_) {
/*   82 */     this.roleid = _o_.roleid;
/*   83 */     this.string_prop_map = new HashMap();
/*   84 */     for (Map.Entry<Integer, String> _e_ : _o_.string_prop_map.entrySet())
/*   85 */       this.string_prop_map.put(_e_.getKey(), _e_.getValue());
/*   86 */     this.int_prop_map = new HashMap();
/*   87 */     for (Map.Entry<Integer, Integer> _e_ : _o_.int_prop_map.entrySet())
/*   88 */       this.int_prop_map.put(_e_.getKey(), _e_.getValue());
/*   89 */     this.modelid = _o_.modelid;
/*   90 */     this.colorid = _o_.colorid;
/*   91 */     this.model_info = new HashMap();
/*   92 */     for (Map.Entry<Integer, Integer> _e_ : _o_.model_info.entrySet()) {
/*   93 */       this.model_info.put(_e_.getKey(), _e_.getValue());
/*      */     }
/*      */   }
/*      */   
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   99 */     _xdb_verify_unsafe_();
/*  100 */     _os_.marshal(this.roleid);
/*  101 */     _os_.compact_uint32(this.string_prop_map.size());
/*  102 */     for (Map.Entry<Integer, String> _e_ : this.string_prop_map.entrySet())
/*      */     {
/*  104 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  105 */       _os_.marshal((String)_e_.getValue(), "UTF-16LE");
/*      */     }
/*  107 */     _os_.compact_uint32(this.int_prop_map.size());
/*  108 */     for (Map.Entry<Integer, Integer> _e_ : this.int_prop_map.entrySet())
/*      */     {
/*  110 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  111 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  113 */     _os_.marshal(this.modelid);
/*  114 */     _os_.marshal(this.colorid);
/*  115 */     _os_.compact_uint32(this.model_info.size());
/*  116 */     for (Map.Entry<Integer, Integer> _e_ : this.model_info.entrySet())
/*      */     {
/*  118 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  119 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  121 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  127 */     _xdb_verify_unsafe_();
/*  128 */     this.roleid = _os_.unmarshal_long();
/*      */     
/*  130 */     int size = _os_.uncompact_uint32();
/*  131 */     if (size >= 12)
/*      */     {
/*  133 */       this.string_prop_map = new HashMap(size * 2);
/*      */     }
/*  135 */     for (; size > 0; size--)
/*      */     {
/*  137 */       int _k_ = 0;
/*  138 */       _k_ = _os_.unmarshal_int();
/*  139 */       String _v_ = "";
/*  140 */       _v_ = _os_.unmarshal_String("UTF-16LE");
/*  141 */       this.string_prop_map.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*      */ 
/*  145 */     int size = _os_.uncompact_uint32();
/*  146 */     if (size >= 12)
/*      */     {
/*  148 */       this.int_prop_map = new HashMap(size * 2);
/*      */     }
/*  150 */     for (; size > 0; size--)
/*      */     {
/*  152 */       int _k_ = 0;
/*  153 */       _k_ = _os_.unmarshal_int();
/*  154 */       int _v_ = 0;
/*  155 */       _v_ = _os_.unmarshal_int();
/*  156 */       this.int_prop_map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  159 */     this.modelid = _os_.unmarshal_int();
/*  160 */     this.colorid = _os_.unmarshal_int();
/*      */     
/*  162 */     int size = _os_.uncompact_uint32();
/*  163 */     if (size >= 12)
/*      */     {
/*  165 */       this.model_info = new HashMap(size * 2);
/*      */     }
/*  167 */     for (; size > 0; size--)
/*      */     {
/*  169 */       int _k_ = 0;
/*  170 */       _k_ = _os_.unmarshal_int();
/*  171 */       int _v_ = 0;
/*  172 */       _v_ = _os_.unmarshal_int();
/*  173 */       this.model_info.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  176 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  182 */     _xdb_verify_unsafe_();
/*  183 */     int _size_ = 0;
/*  184 */     _size_ += CodedOutputStream.computeInt64Size(1, this.roleid);
/*  185 */     for (Map.Entry<Integer, String> _e_ : this.string_prop_map.entrySet())
/*      */     {
/*  187 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/*      */       try
/*      */       {
/*  190 */         _size_ += CodedOutputStream.computeBytesSize(2, ByteString.copyFrom((String)_e_.getValue(), "UTF-16LE"));
/*      */       }
/*      */       catch (java.io.UnsupportedEncodingException e)
/*      */       {
/*  194 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/*      */     }
/*  197 */     for (Map.Entry<Integer, Integer> _e_ : this.int_prop_map.entrySet())
/*      */     {
/*  199 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/*  200 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  202 */     _size_ += CodedOutputStream.computeInt32Size(4, this.modelid);
/*  203 */     _size_ += CodedOutputStream.computeInt32Size(5, this.colorid);
/*  204 */     for (Map.Entry<Integer, Integer> _e_ : this.model_info.entrySet())
/*      */     {
/*  206 */       _size_ += CodedOutputStream.computeInt32Size(6, ((Integer)_e_.getKey()).intValue());
/*  207 */       _size_ += CodedOutputStream.computeInt32Size(6, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  209 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  215 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  218 */       _output_.writeInt64(1, this.roleid);
/*  219 */       for (Map.Entry<Integer, String> _e_ : this.string_prop_map.entrySet())
/*      */       {
/*  221 */         _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/*  222 */         _output_.writeBytes(2, ByteString.copyFrom((String)_e_.getValue(), "UTF-16LE"));
/*      */       }
/*  224 */       for (Map.Entry<Integer, Integer> _e_ : this.int_prop_map.entrySet())
/*      */       {
/*  226 */         _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/*  227 */         _output_.writeInt32(3, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  229 */       _output_.writeInt32(4, this.modelid);
/*  230 */       _output_.writeInt32(5, this.colorid);
/*  231 */       for (Map.Entry<Integer, Integer> _e_ : this.model_info.entrySet())
/*      */       {
/*  233 */         _output_.writeInt32(6, ((Integer)_e_.getKey()).intValue());
/*  234 */         _output_.writeInt32(6, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  239 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  241 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  247 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  250 */       boolean done = false;
/*  251 */       while (!done)
/*      */       {
/*  253 */         int tag = _input_.readTag();
/*  254 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  258 */           done = true;
/*  259 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  263 */           this.roleid = _input_.readInt64();
/*  264 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  268 */           int _k_ = 0;
/*  269 */           _k_ = _input_.readInt32();
/*  270 */           int readTag = _input_.readTag();
/*  271 */           if (18 != readTag)
/*      */           {
/*  273 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  275 */           String _v_ = "";
/*  276 */           _v_ = _input_.readBytes().toString("UTF-16LE");
/*  277 */           this.string_prop_map.put(Integer.valueOf(_k_), _v_);
/*  278 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  282 */           int _k_ = 0;
/*  283 */           _k_ = _input_.readInt32();
/*  284 */           int readTag = _input_.readTag();
/*  285 */           if (24 != readTag)
/*      */           {
/*  287 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  289 */           int _v_ = 0;
/*  290 */           _v_ = _input_.readInt32();
/*  291 */           this.int_prop_map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  292 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  296 */           this.modelid = _input_.readInt32();
/*  297 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  301 */           this.colorid = _input_.readInt32();
/*  302 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  306 */           int _k_ = 0;
/*  307 */           _k_ = _input_.readInt32();
/*  308 */           int readTag = _input_.readTag();
/*  309 */           if (48 != readTag)
/*      */           {
/*  311 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  313 */           int _v_ = 0;
/*  314 */           _v_ = _input_.readInt32();
/*  315 */           this.model_info.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  316 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  320 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  322 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  331 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  335 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  337 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CloneRoleNPCModel copy()
/*      */   {
/*  343 */     _xdb_verify_unsafe_();
/*  344 */     return new CloneRoleNPCModel(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CloneRoleNPCModel toData()
/*      */   {
/*  350 */     _xdb_verify_unsafe_();
/*  351 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.CloneRoleNPCModel toBean()
/*      */   {
/*  356 */     _xdb_verify_unsafe_();
/*  357 */     return new CloneRoleNPCModel(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CloneRoleNPCModel toDataIf()
/*      */   {
/*  363 */     _xdb_verify_unsafe_();
/*  364 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.CloneRoleNPCModel toBeanIf()
/*      */   {
/*  369 */     _xdb_verify_unsafe_();
/*  370 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  376 */     _xdb_verify_unsafe_();
/*  377 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getRoleid()
/*      */   {
/*  384 */     _xdb_verify_unsafe_();
/*  385 */     return this.roleid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, String> getString_prop_map()
/*      */   {
/*  392 */     _xdb_verify_unsafe_();
/*  393 */     return xdb.Logs.logMap(new LogKey(this, "string_prop_map"), this.string_prop_map);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, String> getString_prop_mapAsData()
/*      */   {
/*  400 */     _xdb_verify_unsafe_();
/*      */     
/*  402 */     CloneRoleNPCModel _o_ = this;
/*  403 */     Map<Integer, String> string_prop_map = new HashMap();
/*  404 */     for (Map.Entry<Integer, String> _e_ : _o_.string_prop_map.entrySet())
/*  405 */       string_prop_map.put(_e_.getKey(), _e_.getValue());
/*  406 */     return string_prop_map;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getInt_prop_map()
/*      */   {
/*  413 */     _xdb_verify_unsafe_();
/*  414 */     return xdb.Logs.logMap(new LogKey(this, "int_prop_map"), this.int_prop_map);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getInt_prop_mapAsData()
/*      */   {
/*  421 */     _xdb_verify_unsafe_();
/*      */     
/*  423 */     CloneRoleNPCModel _o_ = this;
/*  424 */     Map<Integer, Integer> int_prop_map = new HashMap();
/*  425 */     for (Map.Entry<Integer, Integer> _e_ : _o_.int_prop_map.entrySet())
/*  426 */       int_prop_map.put(_e_.getKey(), _e_.getValue());
/*  427 */     return int_prop_map;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getModelid()
/*      */   {
/*  434 */     _xdb_verify_unsafe_();
/*  435 */     return this.modelid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getColorid()
/*      */   {
/*  442 */     _xdb_verify_unsafe_();
/*  443 */     return this.colorid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getModel_info()
/*      */   {
/*  450 */     _xdb_verify_unsafe_();
/*  451 */     return xdb.Logs.logMap(new LogKey(this, "model_info"), this.model_info);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getModel_infoAsData()
/*      */   {
/*  458 */     _xdb_verify_unsafe_();
/*      */     
/*  460 */     CloneRoleNPCModel _o_ = this;
/*  461 */     Map<Integer, Integer> model_info = new HashMap();
/*  462 */     for (Map.Entry<Integer, Integer> _e_ : _o_.model_info.entrySet())
/*  463 */       model_info.put(_e_.getKey(), _e_.getValue());
/*  464 */     return model_info;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRoleid(long _v_)
/*      */   {
/*  471 */     _xdb_verify_unsafe_();
/*  472 */     xdb.Logs.logIf(new LogKey(this, "roleid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  476 */         new xdb.logs.LogLong(this, CloneRoleNPCModel.this.roleid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  480 */             CloneRoleNPCModel.this.roleid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  484 */     });
/*  485 */     this.roleid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setModelid(int _v_)
/*      */   {
/*  492 */     _xdb_verify_unsafe_();
/*  493 */     xdb.Logs.logIf(new LogKey(this, "modelid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  497 */         new xdb.logs.LogInt(this, CloneRoleNPCModel.this.modelid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  501 */             CloneRoleNPCModel.this.modelid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  505 */     });
/*  506 */     this.modelid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setColorid(int _v_)
/*      */   {
/*  513 */     _xdb_verify_unsafe_();
/*  514 */     xdb.Logs.logIf(new LogKey(this, "colorid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  518 */         new xdb.logs.LogInt(this, CloneRoleNPCModel.this.colorid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  522 */             CloneRoleNPCModel.this.colorid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  526 */     });
/*  527 */     this.colorid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  533 */     _xdb_verify_unsafe_();
/*  534 */     CloneRoleNPCModel _o_ = null;
/*  535 */     if ((_o1_ instanceof CloneRoleNPCModel)) { _o_ = (CloneRoleNPCModel)_o1_;
/*  536 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  537 */       return false;
/*  538 */     if (this.roleid != _o_.roleid) return false;
/*  539 */     if (!this.string_prop_map.equals(_o_.string_prop_map)) return false;
/*  540 */     if (!this.int_prop_map.equals(_o_.int_prop_map)) return false;
/*  541 */     if (this.modelid != _o_.modelid) return false;
/*  542 */     if (this.colorid != _o_.colorid) return false;
/*  543 */     if (!this.model_info.equals(_o_.model_info)) return false;
/*  544 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  550 */     _xdb_verify_unsafe_();
/*  551 */     int _h_ = 0;
/*  552 */     _h_ = (int)(_h_ + this.roleid);
/*  553 */     _h_ += this.string_prop_map.hashCode();
/*  554 */     _h_ += this.int_prop_map.hashCode();
/*  555 */     _h_ += this.modelid;
/*  556 */     _h_ += this.colorid;
/*  557 */     _h_ += this.model_info.hashCode();
/*  558 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  564 */     _xdb_verify_unsafe_();
/*  565 */     StringBuilder _sb_ = new StringBuilder();
/*  566 */     _sb_.append("(");
/*  567 */     _sb_.append(this.roleid);
/*  568 */     _sb_.append(",");
/*  569 */     _sb_.append(this.string_prop_map);
/*  570 */     _sb_.append(",");
/*  571 */     _sb_.append(this.int_prop_map);
/*  572 */     _sb_.append(",");
/*  573 */     _sb_.append(this.modelid);
/*  574 */     _sb_.append(",");
/*  575 */     _sb_.append(this.colorid);
/*  576 */     _sb_.append(",");
/*  577 */     _sb_.append(this.model_info);
/*  578 */     _sb_.append(")");
/*  579 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  585 */     ListenableBean lb = new ListenableBean();
/*  586 */     lb.add(new xdb.logs.ListenableChanged().setVarName("roleid"));
/*  587 */     lb.add(new ListenableMap().setVarName("string_prop_map"));
/*  588 */     lb.add(new ListenableMap().setVarName("int_prop_map"));
/*  589 */     lb.add(new xdb.logs.ListenableChanged().setVarName("modelid"));
/*  590 */     lb.add(new xdb.logs.ListenableChanged().setVarName("colorid"));
/*  591 */     lb.add(new ListenableMap().setVarName("model_info"));
/*  592 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.CloneRoleNPCModel {
/*      */     private Const() {}
/*      */     
/*      */     CloneRoleNPCModel nThis() {
/*  599 */       return CloneRoleNPCModel.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  605 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CloneRoleNPCModel copy()
/*      */     {
/*  611 */       return CloneRoleNPCModel.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CloneRoleNPCModel toData()
/*      */     {
/*  617 */       return CloneRoleNPCModel.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.CloneRoleNPCModel toBean()
/*      */     {
/*  622 */       return CloneRoleNPCModel.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CloneRoleNPCModel toDataIf()
/*      */     {
/*  628 */       return CloneRoleNPCModel.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.CloneRoleNPCModel toBeanIf()
/*      */     {
/*  633 */       return CloneRoleNPCModel.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRoleid()
/*      */     {
/*  640 */       CloneRoleNPCModel.this._xdb_verify_unsafe_();
/*  641 */       return CloneRoleNPCModel.this.roleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, String> getString_prop_map()
/*      */     {
/*  648 */       CloneRoleNPCModel.this._xdb_verify_unsafe_();
/*  649 */       return xdb.Consts.constMap(CloneRoleNPCModel.this.string_prop_map);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, String> getString_prop_mapAsData()
/*      */     {
/*  656 */       CloneRoleNPCModel.this._xdb_verify_unsafe_();
/*      */       
/*  658 */       CloneRoleNPCModel _o_ = CloneRoleNPCModel.this;
/*  659 */       Map<Integer, String> string_prop_map = new HashMap();
/*  660 */       for (Map.Entry<Integer, String> _e_ : _o_.string_prop_map.entrySet())
/*  661 */         string_prop_map.put(_e_.getKey(), _e_.getValue());
/*  662 */       return string_prop_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getInt_prop_map()
/*      */     {
/*  669 */       CloneRoleNPCModel.this._xdb_verify_unsafe_();
/*  670 */       return xdb.Consts.constMap(CloneRoleNPCModel.this.int_prop_map);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getInt_prop_mapAsData()
/*      */     {
/*  677 */       CloneRoleNPCModel.this._xdb_verify_unsafe_();
/*      */       
/*  679 */       CloneRoleNPCModel _o_ = CloneRoleNPCModel.this;
/*  680 */       Map<Integer, Integer> int_prop_map = new HashMap();
/*  681 */       for (Map.Entry<Integer, Integer> _e_ : _o_.int_prop_map.entrySet())
/*  682 */         int_prop_map.put(_e_.getKey(), _e_.getValue());
/*  683 */       return int_prop_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getModelid()
/*      */     {
/*  690 */       CloneRoleNPCModel.this._xdb_verify_unsafe_();
/*  691 */       return CloneRoleNPCModel.this.modelid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getColorid()
/*      */     {
/*  698 */       CloneRoleNPCModel.this._xdb_verify_unsafe_();
/*  699 */       return CloneRoleNPCModel.this.colorid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getModel_info()
/*      */     {
/*  706 */       CloneRoleNPCModel.this._xdb_verify_unsafe_();
/*  707 */       return xdb.Consts.constMap(CloneRoleNPCModel.this.model_info);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getModel_infoAsData()
/*      */     {
/*  714 */       CloneRoleNPCModel.this._xdb_verify_unsafe_();
/*      */       
/*  716 */       CloneRoleNPCModel _o_ = CloneRoleNPCModel.this;
/*  717 */       Map<Integer, Integer> model_info = new HashMap();
/*  718 */       for (Map.Entry<Integer, Integer> _e_ : _o_.model_info.entrySet())
/*  719 */         model_info.put(_e_.getKey(), _e_.getValue());
/*  720 */       return model_info;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRoleid(long _v_)
/*      */     {
/*  727 */       CloneRoleNPCModel.this._xdb_verify_unsafe_();
/*  728 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setModelid(int _v_)
/*      */     {
/*  735 */       CloneRoleNPCModel.this._xdb_verify_unsafe_();
/*  736 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setColorid(int _v_)
/*      */     {
/*  743 */       CloneRoleNPCModel.this._xdb_verify_unsafe_();
/*  744 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  750 */       CloneRoleNPCModel.this._xdb_verify_unsafe_();
/*  751 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  757 */       CloneRoleNPCModel.this._xdb_verify_unsafe_();
/*  758 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  764 */       return CloneRoleNPCModel.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  770 */       return CloneRoleNPCModel.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  776 */       CloneRoleNPCModel.this._xdb_verify_unsafe_();
/*  777 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  783 */       return CloneRoleNPCModel.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  789 */       return CloneRoleNPCModel.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  795 */       CloneRoleNPCModel.this._xdb_verify_unsafe_();
/*  796 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  802 */       return CloneRoleNPCModel.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  808 */       return CloneRoleNPCModel.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  814 */       return CloneRoleNPCModel.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  820 */       return CloneRoleNPCModel.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  826 */       return CloneRoleNPCModel.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  832 */       return CloneRoleNPCModel.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  838 */       return CloneRoleNPCModel.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.CloneRoleNPCModel
/*      */   {
/*      */     private long roleid;
/*      */     
/*      */     private HashMap<Integer, String> string_prop_map;
/*      */     
/*      */     private HashMap<Integer, Integer> int_prop_map;
/*      */     
/*      */     private int modelid;
/*      */     
/*      */     private int colorid;
/*      */     
/*      */     private HashMap<Integer, Integer> model_info;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  860 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  865 */       this.string_prop_map = new HashMap();
/*  866 */       this.int_prop_map = new HashMap();
/*  867 */       this.model_info = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.CloneRoleNPCModel _o1_)
/*      */     {
/*  872 */       if ((_o1_ instanceof CloneRoleNPCModel)) { assign((CloneRoleNPCModel)_o1_);
/*  873 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  874 */       } else if ((_o1_ instanceof CloneRoleNPCModel.Const)) assign(((CloneRoleNPCModel.Const)_o1_).nThis()); else {
/*  875 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(CloneRoleNPCModel _o_) {
/*  880 */       this.roleid = _o_.roleid;
/*  881 */       this.string_prop_map = new HashMap();
/*  882 */       for (Map.Entry<Integer, String> _e_ : _o_.string_prop_map.entrySet())
/*  883 */         this.string_prop_map.put(_e_.getKey(), _e_.getValue());
/*  884 */       this.int_prop_map = new HashMap();
/*  885 */       for (Map.Entry<Integer, Integer> _e_ : _o_.int_prop_map.entrySet())
/*  886 */         this.int_prop_map.put(_e_.getKey(), _e_.getValue());
/*  887 */       this.modelid = _o_.modelid;
/*  888 */       this.colorid = _o_.colorid;
/*  889 */       this.model_info = new HashMap();
/*  890 */       for (Map.Entry<Integer, Integer> _e_ : _o_.model_info.entrySet()) {
/*  891 */         this.model_info.put(_e_.getKey(), _e_.getValue());
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Data _o_) {
/*  896 */       this.roleid = _o_.roleid;
/*  897 */       this.string_prop_map = new HashMap();
/*  898 */       for (Map.Entry<Integer, String> _e_ : _o_.string_prop_map.entrySet())
/*  899 */         this.string_prop_map.put(_e_.getKey(), _e_.getValue());
/*  900 */       this.int_prop_map = new HashMap();
/*  901 */       for (Map.Entry<Integer, Integer> _e_ : _o_.int_prop_map.entrySet())
/*  902 */         this.int_prop_map.put(_e_.getKey(), _e_.getValue());
/*  903 */       this.modelid = _o_.modelid;
/*  904 */       this.colorid = _o_.colorid;
/*  905 */       this.model_info = new HashMap();
/*  906 */       for (Map.Entry<Integer, Integer> _e_ : _o_.model_info.entrySet()) {
/*  907 */         this.model_info.put(_e_.getKey(), _e_.getValue());
/*      */       }
/*      */     }
/*      */     
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  913 */       _os_.marshal(this.roleid);
/*  914 */       _os_.compact_uint32(this.string_prop_map.size());
/*  915 */       for (Map.Entry<Integer, String> _e_ : this.string_prop_map.entrySet())
/*      */       {
/*  917 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  918 */         _os_.marshal((String)_e_.getValue(), "UTF-16LE");
/*      */       }
/*  920 */       _os_.compact_uint32(this.int_prop_map.size());
/*  921 */       for (Map.Entry<Integer, Integer> _e_ : this.int_prop_map.entrySet())
/*      */       {
/*  923 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  924 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/*  926 */       _os_.marshal(this.modelid);
/*  927 */       _os_.marshal(this.colorid);
/*  928 */       _os_.compact_uint32(this.model_info.size());
/*  929 */       for (Map.Entry<Integer, Integer> _e_ : this.model_info.entrySet())
/*      */       {
/*  931 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  932 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/*  934 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  940 */       this.roleid = _os_.unmarshal_long();
/*      */       
/*  942 */       int size = _os_.uncompact_uint32();
/*  943 */       if (size >= 12)
/*      */       {
/*  945 */         this.string_prop_map = new HashMap(size * 2);
/*      */       }
/*  947 */       for (; size > 0; size--)
/*      */       {
/*  949 */         int _k_ = 0;
/*  950 */         _k_ = _os_.unmarshal_int();
/*  951 */         String _v_ = "";
/*  952 */         _v_ = _os_.unmarshal_String("UTF-16LE");
/*  953 */         this.string_prop_map.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*      */ 
/*  957 */       int size = _os_.uncompact_uint32();
/*  958 */       if (size >= 12)
/*      */       {
/*  960 */         this.int_prop_map = new HashMap(size * 2);
/*      */       }
/*  962 */       for (; size > 0; size--)
/*      */       {
/*  964 */         int _k_ = 0;
/*  965 */         _k_ = _os_.unmarshal_int();
/*  966 */         int _v_ = 0;
/*  967 */         _v_ = _os_.unmarshal_int();
/*  968 */         this.int_prop_map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*  971 */       this.modelid = _os_.unmarshal_int();
/*  972 */       this.colorid = _os_.unmarshal_int();
/*      */       
/*  974 */       int size = _os_.uncompact_uint32();
/*  975 */       if (size >= 12)
/*      */       {
/*  977 */         this.model_info = new HashMap(size * 2);
/*      */       }
/*  979 */       for (; size > 0; size--)
/*      */       {
/*  981 */         int _k_ = 0;
/*  982 */         _k_ = _os_.unmarshal_int();
/*  983 */         int _v_ = 0;
/*  984 */         _v_ = _os_.unmarshal_int();
/*  985 */         this.model_info.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*  988 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  994 */       int _size_ = 0;
/*  995 */       _size_ += CodedOutputStream.computeInt64Size(1, this.roleid);
/*  996 */       for (Map.Entry<Integer, String> _e_ : this.string_prop_map.entrySet())
/*      */       {
/*  998 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/*      */         try
/*      */         {
/* 1001 */           _size_ += CodedOutputStream.computeBytesSize(2, ByteString.copyFrom((String)_e_.getValue(), "UTF-16LE"));
/*      */         }
/*      */         catch (java.io.UnsupportedEncodingException e)
/*      */         {
/* 1005 */           throw new RuntimeException("UTF-16LE not supported?", e);
/*      */         }
/*      */       }
/* 1008 */       for (Map.Entry<Integer, Integer> _e_ : this.int_prop_map.entrySet())
/*      */       {
/* 1010 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/* 1011 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getValue()).intValue());
/*      */       }
/* 1013 */       _size_ += CodedOutputStream.computeInt32Size(4, this.modelid);
/* 1014 */       _size_ += CodedOutputStream.computeInt32Size(5, this.colorid);
/* 1015 */       for (Map.Entry<Integer, Integer> _e_ : this.model_info.entrySet())
/*      */       {
/* 1017 */         _size_ += CodedOutputStream.computeInt32Size(6, ((Integer)_e_.getKey()).intValue());
/* 1018 */         _size_ += CodedOutputStream.computeInt32Size(6, ((Integer)_e_.getValue()).intValue());
/*      */       }
/* 1020 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1028 */         _output_.writeInt64(1, this.roleid);
/* 1029 */         for (Map.Entry<Integer, String> _e_ : this.string_prop_map.entrySet())
/*      */         {
/* 1031 */           _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/* 1032 */           _output_.writeBytes(2, ByteString.copyFrom((String)_e_.getValue(), "UTF-16LE"));
/*      */         }
/* 1034 */         for (Map.Entry<Integer, Integer> _e_ : this.int_prop_map.entrySet())
/*      */         {
/* 1036 */           _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/* 1037 */           _output_.writeInt32(3, ((Integer)_e_.getValue()).intValue());
/*      */         }
/* 1039 */         _output_.writeInt32(4, this.modelid);
/* 1040 */         _output_.writeInt32(5, this.colorid);
/* 1041 */         for (Map.Entry<Integer, Integer> _e_ : this.model_info.entrySet())
/*      */         {
/* 1043 */           _output_.writeInt32(6, ((Integer)_e_.getKey()).intValue());
/* 1044 */           _output_.writeInt32(6, ((Integer)_e_.getValue()).intValue());
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1049 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1051 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1059 */         boolean done = false;
/* 1060 */         while (!done)
/*      */         {
/* 1062 */           int tag = _input_.readTag();
/* 1063 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1067 */             done = true;
/* 1068 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1072 */             this.roleid = _input_.readInt64();
/* 1073 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1077 */             int _k_ = 0;
/* 1078 */             _k_ = _input_.readInt32();
/* 1079 */             int readTag = _input_.readTag();
/* 1080 */             if (18 != readTag)
/*      */             {
/* 1082 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1084 */             String _v_ = "";
/* 1085 */             _v_ = _input_.readBytes().toString("UTF-16LE");
/* 1086 */             this.string_prop_map.put(Integer.valueOf(_k_), _v_);
/* 1087 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1091 */             int _k_ = 0;
/* 1092 */             _k_ = _input_.readInt32();
/* 1093 */             int readTag = _input_.readTag();
/* 1094 */             if (24 != readTag)
/*      */             {
/* 1096 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1098 */             int _v_ = 0;
/* 1099 */             _v_ = _input_.readInt32();
/* 1100 */             this.int_prop_map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 1101 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1105 */             this.modelid = _input_.readInt32();
/* 1106 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1110 */             this.colorid = _input_.readInt32();
/* 1111 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1115 */             int _k_ = 0;
/* 1116 */             _k_ = _input_.readInt32();
/* 1117 */             int readTag = _input_.readTag();
/* 1118 */             if (48 != readTag)
/*      */             {
/* 1120 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1122 */             int _v_ = 0;
/* 1123 */             _v_ = _input_.readInt32();
/* 1124 */             this.model_info.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 1125 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1129 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1131 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1140 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1144 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1146 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CloneRoleNPCModel copy()
/*      */     {
/* 1152 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CloneRoleNPCModel toData()
/*      */     {
/* 1158 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.CloneRoleNPCModel toBean()
/*      */     {
/* 1163 */       return new CloneRoleNPCModel(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CloneRoleNPCModel toDataIf()
/*      */     {
/* 1169 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.CloneRoleNPCModel toBeanIf()
/*      */     {
/* 1174 */       return new CloneRoleNPCModel(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1180 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1184 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1188 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1192 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1196 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1200 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1204 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRoleid()
/*      */     {
/* 1211 */       return this.roleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, String> getString_prop_map()
/*      */     {
/* 1218 */       return this.string_prop_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, String> getString_prop_mapAsData()
/*      */     {
/* 1225 */       return this.string_prop_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getInt_prop_map()
/*      */     {
/* 1232 */       return this.int_prop_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getInt_prop_mapAsData()
/*      */     {
/* 1239 */       return this.int_prop_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getModelid()
/*      */     {
/* 1246 */       return this.modelid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getColorid()
/*      */     {
/* 1253 */       return this.colorid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getModel_info()
/*      */     {
/* 1260 */       return this.model_info;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getModel_infoAsData()
/*      */     {
/* 1267 */       return this.model_info;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRoleid(long _v_)
/*      */     {
/* 1274 */       this.roleid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setModelid(int _v_)
/*      */     {
/* 1281 */       this.modelid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setColorid(int _v_)
/*      */     {
/* 1288 */       this.colorid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1294 */       if (!(_o1_ instanceof Data)) return false;
/* 1295 */       Data _o_ = (Data)_o1_;
/* 1296 */       if (this.roleid != _o_.roleid) return false;
/* 1297 */       if (!this.string_prop_map.equals(_o_.string_prop_map)) return false;
/* 1298 */       if (!this.int_prop_map.equals(_o_.int_prop_map)) return false;
/* 1299 */       if (this.modelid != _o_.modelid) return false;
/* 1300 */       if (this.colorid != _o_.colorid) return false;
/* 1301 */       if (!this.model_info.equals(_o_.model_info)) return false;
/* 1302 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1308 */       int _h_ = 0;
/* 1309 */       _h_ = (int)(_h_ + this.roleid);
/* 1310 */       _h_ += this.string_prop_map.hashCode();
/* 1311 */       _h_ += this.int_prop_map.hashCode();
/* 1312 */       _h_ += this.modelid;
/* 1313 */       _h_ += this.colorid;
/* 1314 */       _h_ += this.model_info.hashCode();
/* 1315 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1321 */       StringBuilder _sb_ = new StringBuilder();
/* 1322 */       _sb_.append("(");
/* 1323 */       _sb_.append(this.roleid);
/* 1324 */       _sb_.append(",");
/* 1325 */       _sb_.append(this.string_prop_map);
/* 1326 */       _sb_.append(",");
/* 1327 */       _sb_.append(this.int_prop_map);
/* 1328 */       _sb_.append(",");
/* 1329 */       _sb_.append(this.modelid);
/* 1330 */       _sb_.append(",");
/* 1331 */       _sb_.append(this.colorid);
/* 1332 */       _sb_.append(",");
/* 1333 */       _sb_.append(this.model_info);
/* 1334 */       _sb_.append(")");
/* 1335 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\CloneRoleNPCModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */